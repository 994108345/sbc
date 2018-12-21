package cn.wzl.sbc.common.util;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author wzl
 * @Date 2018/12/17 11:38
 * @doc Md5Util
 **/
public class Md5Util {

    /**利用MD5进行加密*/
    public static String EncoderByMd5(String str){
        byte[] secretBytes = null;
        try {
            /*生成md5的字节*/
            secretBytes = MessageDigest.getInstance("md5").digest(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        // 16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
