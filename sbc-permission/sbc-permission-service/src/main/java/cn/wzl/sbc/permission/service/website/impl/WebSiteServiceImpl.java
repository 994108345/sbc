package cn.wzl.sbc.permission.service.website.impl;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.permission.service.website.WebSiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/27 18:41
 * @doc WebSiteServiceImpl
 **/
@Service("webSiteService")
public class WebSiteServiceImpl implements WebSiteService {

    private final static Logger log = LoggerFactory.getLogger(WebSiteServiceImpl.class);

    @Resource
    private RedisUtil redisUtil;

    @Override
    public MessageResult saveAccessCount() {
        MessageResult result = new MessageResult();

        try {
            /*调用redis方法*/
            redisUtil.addOne(RedisConstant.RedisKeys.WEBSITE_ACCESS_COUNT_KEY, RedisConstant.WEBSITE_ACCESS_COUNT_ADD_NUM);
        } catch (Exception e) {
            log.error("save the website accessCount which has error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"save website accessCount has error" + e.getMessage());
        }
        return null;
    }

    @Override
    public MessageResult getAccessCount(String key) {
        MessageResult result = new MessageResult();
        return null;
    }
}
