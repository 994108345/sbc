package cn.wzl.sbc.permission.service.login;

import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;

/**
 * @Author wzl
 * @Date 2018/12/13 18:53
 * @doc LoginService
 **/
public interface LoginService {

    /**
     * 登陆
     * @param userInfo
     * @return
     */
    MessageResult login(UserInfo userInfo);
}
