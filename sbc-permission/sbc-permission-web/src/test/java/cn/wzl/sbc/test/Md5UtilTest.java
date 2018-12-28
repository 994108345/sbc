package cn.wzl.sbc.test;

import cn.wzl.sbc.common.util.Md5Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author wzl
 * @Date 2018/12/17 11:57
 * @doc Md5UtilTest
 **/
public class Md5UtilTest {
    @Test
    public void test(){
        String password = "wzl";
        try {
            String passwordMod5 = Md5Util.EncoderByMd5(password);
            System.out.println(passwordMod5);
        } catch (Exception e) {

        }
    }

    @Test
    public void nullTest(){
        List<String> list = new ArrayList<>();
        list.add("2");
        if(list.size() > 0){
            String a = list.get(2);
        }


    }


}
