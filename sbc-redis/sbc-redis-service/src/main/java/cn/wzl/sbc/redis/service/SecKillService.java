package cn.wzl.sbc.redis.service;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserInfo;

/**
 * @Author wzl
 * @Date 2019/1/9 17:38
 * @doc SecKillService
 **/
public interface SecKillService {

    /**
     * 秒杀
     * @return
     */
    MessageResult secKill(UserInfo userInfo);
}
