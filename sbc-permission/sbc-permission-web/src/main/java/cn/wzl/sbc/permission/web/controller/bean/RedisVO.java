package cn.wzl.sbc.permission.web.controller.bean;

import cn.wzl.sbc.model.permission.UserInfo;

/**
 * @Author wzl
 * @Date 2018/12/27 20:08
 * @doc RedisVO
 **/
public class RedisVO extends UserInfo {
    /**
     * 键值
     */
    private String key;

    /**
     * 用户信息
     */
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
