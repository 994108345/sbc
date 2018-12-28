package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.permission.service.website.WebSiteService;
import cn.wzl.sbc.permission.web.controller.bean.RedisVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/27 19:50
 * @doc WebSiteController
 **/
@RestController
@RequestMapping("sbc-permission/Website")
public class WebSiteController {

    @Resource
    private WebSiteService webSiteService;

    /**
     * 记录网页访问次数
     * @return
     */
    @PostMapping("addAccessCount")
    @ResponseBody
    public MessageResult addAccessCount(@RequestBody RedisVO redisVO){
        MessageResult result = webSiteService.saveAccessCount();
        /*参数校验*/
        if(redisVO == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求参数不能为null");
            return result;
        }
        UserInfo userInfo = redisVO.getUserInfo();

        if(userInfo == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户不能为null");
            return result;
        }
        String userName = userInfo.getUserName();
        if(StringUtils.isBlank(userName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户名不能为null");
            return result;
        }

        /*不记录测试用的账号*/
        if(userName.equals("1111")){
            return result;
        }
        return result;
    }

    /**
     * 获取网页访问次数
     * @return
     */
    @PostMapping("getAccessCount")
    @ResponseBody
    public MessageResult getAccessCount(@RequestBody RedisVO redisVO){
        MessageResult result = new MessageResult();
        /*参数校验*/
        if(redisVO == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求参数不能为null");
            return result;
        }
        UserInfo userInfo = redisVO.getUserInfo();

        if(userInfo == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户不能为null");
            return result;
        }
        String userName = userInfo.getUserName();
        if(StringUtils.isBlank(userName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户名不能为null");
            return result;
        }

        result = webSiteService.getAccessCount(redisVO.getKey());
        return result;
    }



}
