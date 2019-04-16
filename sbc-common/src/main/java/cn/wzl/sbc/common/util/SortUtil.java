package cn.wzl.sbc.common.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 排序工具类
 * @author wzl
 * @date Created in 2019/4/9 10:47
 */
public class SortUtil {


    /**
     * 数组按字母排序，转成list返回
     * @param strs
     * @return
     */
    public static List<String> ArraysSortToList(String[] strs){
        //数组转成list
        List<String> list = Arrays.asList(strs);
        //按字母排序
        Collections.sort(list);
        return list;
    }
}
