package cn.wzl.sbc.prod.service.oss;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserMessage;

/**
 * @author wzl
 * @date Created in 2019/5/5 21:13
 */
public interface OssService {

    /**
     * 获取oss的授权访问url,
     * @return
     */
    MessageResult getSTSUrl(UserMessage userMessage);

}
