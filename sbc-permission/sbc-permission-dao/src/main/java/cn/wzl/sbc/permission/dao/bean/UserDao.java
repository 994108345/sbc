package cn.wzl.sbc.permission.dao.bean;


import cn.wzl.sbc.model.permission.UserInfo;

import java.util.List;

public interface UserDao {
    /**
     * 插入
     * @param userInfo
     * @return
     */
    int insertSelective(UserInfo userInfo);

    /**
     * 查询用户信息集合
     * @param userInfo
     * @return
     */
    List<UserInfo> listUserInfoByCondition(UserInfo userInfo);
}
