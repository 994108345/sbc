/*
package cn.wzl.sbc.permission.interceptor;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

*/
/**
 * @Author wzl
 * @Date 2018/12/21 13:01
 * @doc 有缺陷，无法拦截到父模块的请求，暂时放弃
 **//*

*/
/*@Aspect*//*

@Component
public class InterceptControllerAspect {
    @Resource
    private RedisUtil redisUtil;

    private static final Logger logger = LoggerFactory.getLogger(InterceptControllerAspect.class);

    @Before("@annotation(cn.wzl.sbc.common.annotation.LogAccept)")
    public MessageResult beforeMethod(JoinPoint joinPoint){
        MessageResult result = new MessageResult();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = request.getCookies();
        */
/*标签是否有cookie*//*

        boolean isCookie = false;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(CommonConstant.CookieConstant.token.equals(name)){
                String value = cookie.getValue();
                */
/*查看redis是否有该key*//*

                String token = (String)redisUtil.getByKey(value);
                if(token == null){
                    result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请登录后再请求");
                    isCookie = false;
                }else{
                    isCookie = true;
                }
                break;
            }
        }
        return result;
    }
}
*/
