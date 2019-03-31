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
    public String getStrOfLength(int endLength,String str){
        int length = str.length();
        return str.substring(0,length > endLength? endLength:length);
    }

    /**
     * 删除指定两个标签内之间的内容
     * @param str
     * @param tag2
     * @return
     */
    public String subString(String str,String tag1,String tag2){
        return null;
    }
}
