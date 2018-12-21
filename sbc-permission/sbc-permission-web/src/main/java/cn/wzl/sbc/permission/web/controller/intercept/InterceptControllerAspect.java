package cn.wzl.sbc.permission.web.controller.intercept;

import cn.wzl.sbc.common.result.MessageResult;
import com.alibaba.druid.sql.ast.SQLParameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    private static final Logger logger = LoggerFactory.getLogger(InterceptControllerAspect.class);

    @Pointcut("execution(* cn.wzl.sbc.permission.web.controller.login.*.*(..))")
    public void interceptController() {
        System.out.println("");

    }

    @Before("interceptController()")
    public MessageResult beforeMethod(JoinPoint joinPoint){
        MessageResult result = new MessageResult();

        logger.error("进来了吗！！！！！！！！！！！！！");
        try{
            Object[] objects = joinPoint.getArgs();
            for (Object object : objects) {
                System.out.println(object);
            }
        }catch (Exception e){
            logger.error("springAop错误了"+ e.getMessage());
        }

        return result;
    }
}
