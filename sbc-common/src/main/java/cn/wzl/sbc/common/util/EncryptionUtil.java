package cn.wzl.sbc.common.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 加密工具类
 * @author wzl
 * @date Created in 2019/4/9 11:14
 */
public class EncryptionUtil {

    /**
     * 加密()
     * @param str 加密文本
     * @param strType 加密类型（MD5，SHA-1，SHA-224，SHA-256，SHA-512）
     * @return
     */
    public static String md5Hash(final String str, final String strType) throws NoSuchAlgorithmException {
        String strResult;
        // 创建加密对象 并傳入加密类型
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // 传入要加密的字符串
        messageDigest.update(str.getBytes( StandardCharsets.UTF_8));
        // 得到 byte 类型结果
        byte byteBuffer[] = messageDigest.digest();
        // 將 byte 转为 string
        StringBuffer strHexString = new StringBuffer();
        // 遍历 byte buffer
        for (int i = 0; i < byteBuffer.length; i++) {
            String hex = Integer.toHexString(0xff & byteBuffer[i]);
            if (hex.length() == 1)
            {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        // 得到返回结果
        strResult = strHexString.toString();
        return strResult;
    }
}
