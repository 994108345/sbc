package sbc.permission.interceptor.test;

import cn.wzl.sbc.model.permission.UserInfo;
import org.junit.Test;

public class TypeTest {

    @Test
    public void  typeTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("123");
        userInfo.setUserName("123");
        String typeName = getTypeName(userInfo);
        System.out.println(typeName);
    }

    public String getTypeName(Object obj){
        return obj.getClass().getTypeName();
    }

}
