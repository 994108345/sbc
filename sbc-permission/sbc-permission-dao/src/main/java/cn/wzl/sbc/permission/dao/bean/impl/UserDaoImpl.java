package cn.wzl.sbc.permission.dao.bean.impl;

import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.permission.dao.bean.UserDao;
import cn.wzl.sbc.permission.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author user
 * @Date 2018/11/16 11:27
 **/

@Repository
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


    @Override
    public List<UserInfo> listUserInfoByCondition(UserInfo userInfo) {
        List<UserInfo> userInfos = mapper.listUserInfoByCondition(userInfo);
        return userInfos;
    }
}
