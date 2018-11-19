package cn.wzl.sbc.pay.dao;

import cn.wzl.sbc.pay.dao.bean.UserDao;
import cn.wzl.sbc.pay.module.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/16 13:05
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ManageDaoApplication.class)
public class test {

    @Resource
    private UserDao userDao;

    @Test
    public void insertSelective(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode("00001");
        userInfo.setUserName("wzl");
        userInfo.setPassWord("wzl");

        int count = userDao.insertSelective(userInfo);
        System.out.println(count);
    }
}
