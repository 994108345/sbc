package cn.wzl.sbc.redis.web.controller;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.constant.RestConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.redis.service.SecKillService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author wzl
 * @Date 2019/1/9 17:19
 * @doc cn.wzl.sbc.redis.web.controller.SecKillController
 **/
@RestController
@RequestMapping("sbc-redis/SecKill")
public class SecKillController {

    @Resource
    private SecKillService secKillService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private KafkaTemplate kafkaTemplate;

    /**
     * 秒杀(暂时弃用)
     *
     * @param userInfo
     */
    @PostMapping("kill")
    @ResponseBody
    public MessageResult secKill(@RequestBody UserInfo userInfo) {
        MessageResult result = new MessageResult();
        if (userInfo == null) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(), "请求参数不能为null");
            return result;
        }
        String userName = userInfo.getUserName();
        if (userName.equals(userName)) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(), "用户名不能为空");
            return result;
        }
        return secKillService.secKill(userInfo);
    }

    /**
     * 开始秒杀
     * @param userInfo
     * @return
     */
    @PostMapping("beginKill")
    @ResponseBody
    public MessageResult beginKill(@RequestBody UserInfo userInfo) throws ExecutionException, InterruptedException {
        MessageResult result = new MessageResult();
        List<UserInfo> userInfoList = new ArrayList<>();
        /*去测试账户*/
        String userInfoJson = RestConstant.SECKILL_USERINFO_JSON;
        userInfoList = JSON.parseArray(userInfoJson, UserInfo.class);
        /*阿里推荐手动创建线程池*/
        ScheduledExecutorService executorService =
                new ScheduledThreadPoolExecutor(
                        10, new BasicThreadFactory.Builder()
                        .namingPattern("example-chedule-pool-%d")
                        .daemon(true).build()
                );
        /*返回集合*/
        List<MessageResult> resultList = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            UserInfo user = userInfoList.get(i);
            Future<MessageResult> future = executorService.submit(new Callable<MessageResult>() {
                @Override
                public MessageResult call() throws Exception {
                    return secKillService.secKill(user);
                }
            });
            MessageResult futureResult = future.get();
            futureResult.setUserInfo(user);
            /*返回的结果*/
            resultList.add(futureResult);
        }
        /*阻止新来的任务提交*/
        executorService.shutdown();
        result.setData(resultList);
        return result;
    }

    @PostMapping("resetSeckill")
    @ResponseBody
    public MessageResult reSetSecKill(@RequestBody UserInfo userInfo){
        MessageResult result = new MessageResult();
        /**
         * 删除redis
         */
        redisUtil.delByKey(RedisConstant.RedisKeys.SECKILL_KEY);
        /**
         * 控制开关设置为初始状态
         */
        secKillService.setIsEnough();

        return result;
    }

    /**
     * 秒杀(使用kafka实现)
     * @param userInfo
     * @return
     */
    @PostMapping("seckillByMq")
    @ResponseBody
    public MessageResult seckillByMq(@RequestBody UserInfo userInfo){
        MessageResult result = new MessageResult();

        return result;
    }

}
