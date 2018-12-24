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
    public int insertOneUserInfo(UserInfo userInfo) throws Exception {
        int count = mapper.insertOneUserInfo(userInfo);
        if(count < 1){
            throw new Exception("插入用户记录数小于1");
        }
        return count;
    }


    @Override
    public List<UserInfo> listUserInfoByCondition(UserInfo userInfo) throws Exception {
        List<UserInfo> userInfos = mapper.listUserInfoByCondition(userInfo);
        if(userInfos == null){
            throw new Exception("查询用户列表结果为null");
        }
        return userInfos;
    }
}
