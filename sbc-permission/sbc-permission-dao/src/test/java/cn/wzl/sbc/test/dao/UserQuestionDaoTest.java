package cn.wzl.sbc.test.dao;

import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.dao.bean.UserQuestionDao;
import cn.wzl.sbc.PermissionApplication;
import cn.wzl.sbc.test.base.SbcBaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/25 17:36
 * @doc UserQuestionDaoTest
 **/

public class UserQuestionDaoTest extends SbcBaseTest {

    @Resource
    private UserQuestionDao userQuestionDao;

    @Test
    public void insertByBatchTest() throws Exception {
        List<UserQuestion> list = new ArrayList<>();

        UserQuestion userQuestion1 = new UserQuestion();
        userQuestion1.setUserName("222");
        userQuestion1.setQuestionComment("222");
        userQuestion1.setQuestionAnswer("222");

        UserQuestion userQuestion2 = new UserQuestion();
        userQuestion2.setUserName("111");
        userQuestion2.setQuestionComment("111");
        userQuestion2.setQuestionAnswer("111");

        list.add(userQuestion1);
        list.add(userQuestion2);

        int count = userQuestionDao.insertByBatch(list);

        System.out.println(count);
    }
}
