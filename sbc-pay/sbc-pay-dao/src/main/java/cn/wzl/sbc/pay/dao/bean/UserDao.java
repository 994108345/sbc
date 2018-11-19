package cn.wzl.sbc.pay.dao.bean;

import cn.wzl.sbc.pay.module.UserInfo;

public interface UserDao {
    int insertSelective(UserInfo userInfo);
}
