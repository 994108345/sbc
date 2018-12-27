package cn.wzl.sbc.test.dao;

import cn.wzl.sbc.model.permission.UserQuestion;
import org.junit.Test;

/**
 * @Author wzl
 * @Date 2018/12/27 13:05
 * @doc DemoTest
 **/
public class DemoTest {
    @Test
    public void testDemo1(){
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setId(null);

        try {

            if(userQuestion.getId() == -2){
                System.out.println("1");
            }else {
                System.out.println("2");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
