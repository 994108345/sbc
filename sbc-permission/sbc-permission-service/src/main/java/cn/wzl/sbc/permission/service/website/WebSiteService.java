package cn.wzl.sbc.permission.service.website;

import cn.wzl.sbc.common.result.MessageResult;

/**
 * @Author wzl
 * @Date 2018/12/27 18:40
 * @doc WebSiteService
 **/
public interface WebSiteService {

    /**
     * 记录访问次数
     * @return
     */
    MessageResult saveAccessCount();

    /**
     * 获取访问次数
     * @param key
     * @return
     */
    MessageResult getAccessCount(String key);

}
