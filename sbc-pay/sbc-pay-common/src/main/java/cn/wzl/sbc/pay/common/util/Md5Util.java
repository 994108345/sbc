package cn.wzl.sbc.pay.common.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static  String mod5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] md5 = md.digest(data.getBytes());
        BASE64Encoder be = new BASE64Encoder();
        String base64 = be.encode(md5);
        System.out.println(base64);
        return base64;
    }
}
