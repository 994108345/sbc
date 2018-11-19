package cn.wzl.sbc.pay.dao.bean.impl;

import cn.wzl.sbc.pay.dao.bean.UserDao;
import cn.wzl.sbc.pay.dao.mapper.UserMapper;
import cn.wzl.sbc.pay.module.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/16 11:27
 **/

@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper mapper;

    @Override
    public int insertSelective(UserInfo userInfo) {
        int count = 0;
        try {
           count = mapper.insertSelective(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
