package cn.wzl.sbc.permission.service.login;

import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserInfoDtl;

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

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    MessageResult addUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userInfoDtl
     * @return
     */
    MessageResult queryByRequest(UserInfoDtl userInfoDtl);

    /**
     * 更新用户信息
     * @param userInfoDtl
     * @return
     */
    MessageResult updateUserInfo(UserInfoDtl userInfoDtl);

    /**
     * 删除用户信息
     * @param userInfoDtl
     * @return
     */
    MessageResult deleteByRequest(UserInfoDtl userInfoDtl);
}
