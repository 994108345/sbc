package cn.wzl.sbc.test;

import cn.wzl.sbc.common.util.Mod5Util;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
            String passwordMod5 = Mod5Util.EncoderByMd5(password);
            System.out.println(passwordMod5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
