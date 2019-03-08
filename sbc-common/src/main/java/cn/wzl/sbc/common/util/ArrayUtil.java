package cn.wzl.sbc.common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 16:30
 * @description：数组工具类
 */
public class ArrayUtil<T> {

    /**
     * 将字符串数组转换成字符串
     * @param str 字符串数组
     * @param separator 分隔符
     * @return
     */
    public static String arrToStr(String[] str , String separator){
        StringBuilder builder = new StringBuilder("");
        for (String s : str) {
            builder.append(s + separator);
        }
        builder.delete(builder.length()-1,builder.length());
        return builder.toString();
    }

    /**
     * 将集合的元素添加到数组当中，并返回数组
     * @param arr
     * @param list
     * @param type 数组的类型
     * @param <T>
     * @return
     */
    public static<T> T[] arrAddList(T[] arr, List<T> list,Class type){
        int listSize = list.size();
        int arrSize = arr.length;
        T[] oldNew = (T[]) Array.newInstance(type, listSize + arrSize);
        for (int i = 0; i < arrSize; i++) {
            oldNew[i] = arr[i];
        }
        for (int i = 0; i < listSize; i++) {
            oldNew[i+listSize] = list.get(i);
        }
        return oldNew;
    }

    /**
     * 数组对比，返回arr1相对于arr2不同的元素,用集合返回
     * @param arr1
     * @param arr2
     * @param <T>
     * @return
     */
    public static<T> List<T> arrContrast(T[] arr1,T[] arr2){
        List<T> list = new ArrayList();
        Map<T,T> pcMap = new HashMap<>();
        /*拼接字典，准备比对*/
        for (T pc : arr2) {
            pcMap.put(pc,pc);
        }
        for (T pc : arr1) {
            if(pcMap.get(pc) == null){
                list.add(pc);
            }
        }
        return list;
    }
}
