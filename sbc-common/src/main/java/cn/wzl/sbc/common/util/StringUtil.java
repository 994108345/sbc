package cn.wzl.sbc.common.util;

/**
 * Created by 99410 on 2019/3/29.
 */
public class StringUtil {


    /**
     * 截取指定大小的内容
     * @param endLength
     * @return
     */
    public static  String getStrOfLength(int endLength,String str){
        int length = str.length();
        return str.substring(0,length > endLength? endLength:length);
    }

    /**
     * 去除html标签内的内容
     * @param str
     * @return
     */
    public static String wipeHtml(String str){
        String s=str.replaceAll("<[^>]*>","");
        return s;
    }

    /**
     * 删除指定两个标签内之间的内容
     * @param str
     * @param tag2
     * @return
     */
    public static String subString(String str,String tag1,String tag2){
        return null;
    }
}
