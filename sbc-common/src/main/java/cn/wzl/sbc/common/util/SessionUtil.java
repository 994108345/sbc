package cn.wzl.sbc.common.util;

import javax.servlet.http.HttpSession;

/**
 * @Author wzl
 * @Date 2019/1/7 19:35
 * @doc SessionUtil
 **/
public class SessionUtil {

    /**
     * session存值
     * @param session
     * @param key
     * @param value
     */
    public static void setValue(HttpSession session,String key,Object value){
        session.setAttribute(key,value);
    }

    /**
     * 获取session中存的值
     * @param session
     * @param key
     * @return
     */
    public static Object getValue(HttpSession session,String key){
        return session.getAttribute(key);
    }

    /**
     * 根据key删除某个键值对
     * @param session
     * @param key
     */
    public static void removeByKey(HttpSession session,String key){
        session.removeAttribute(key);
    }
}
