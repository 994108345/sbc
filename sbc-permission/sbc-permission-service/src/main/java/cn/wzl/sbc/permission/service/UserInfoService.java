package cn.wzl.sbc.permission.service;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserInfo;

/**
 * @Author wzl
 * @Date 2018/12/26 10:26
 * @doc UserInfoService
 **/
public interface UserInfoService {

    /**
     * 获取用户信息存在
     * @param userInfo
     * @return
     */
    MessageResult getUserInfo(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    MessageResult updatePasswordByuserName(UserInfo userInfo);

}
