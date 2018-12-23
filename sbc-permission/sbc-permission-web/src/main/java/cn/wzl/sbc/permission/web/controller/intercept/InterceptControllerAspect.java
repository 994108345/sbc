package cn.wzl.sbc.permission.web.controller.intercept;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import com.alibaba.druid.sql.ast.SQLParameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

/**
 * @Author wzl
 * @Date 2018/12/21 13:01
 * @doc InterceptControllerAspect
 **/
@Aspect
@Component
public class InterceptControllerAspect {
    @Resource
    private RedisUtil redisUtil;
    private static final Logger logger = LoggerFactory.getLogger(InterceptControllerAspect.class);

    @Before("execution(* cn.wzl.sbc.*.web.controller..*.*(..))")
    public MessageResult beforeMethod(JoinPoint joinPoint){
        MessageResult result = new MessageResult();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(CommonConstant.CookieConstant.LOGIN_NAME.equals(name)){
                String value = cookie.getValue();
                String token = (String)redisUtil.getByKey(value);
                if(token == null){
                    result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请登录后再请求");
                }
            }
        }
        return result;
    }
}
