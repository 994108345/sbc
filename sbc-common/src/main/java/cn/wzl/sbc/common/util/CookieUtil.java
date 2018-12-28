package cn.wzl.sbc.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 99410 on 2018/12/23.
 */
public class CookieUtil {
    /**
     * 设置cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge 单位为秒，如果是负数，则说明是临时cookie，浏览器关闭即删除
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name, value); //设置cookie的key和value值
        cookie.setPath("/");        //路径
        cookie.setMaxAge(maxAge);   //过期时间
        response.addCookie(cookie); //添加cookie
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,
                             String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){  //判断cookieMap是否含有该key
            return cookieMap.get(name);
        }else{
            return null;
        }

    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();        //获取所有的cookie值
        if(cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }



    /**
     * 删除cookie（java中没有真正删除cookie，只是将过期时间设置成0，加快cookie 的死期）
     * @param cookie
     */
    public  static void delCookie(Cookie cookie){
        cookie.setMaxAge(0);
        cookie.setPath("/");
    }
}
