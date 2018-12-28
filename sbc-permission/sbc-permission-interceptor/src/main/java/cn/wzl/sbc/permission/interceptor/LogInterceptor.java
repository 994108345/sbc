package cn.wzl.sbc.permission.interceptor;

import cn.wzl.sbc.common.annotation.LogAccept;
import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.Log;
import cn.wzl.sbc.permission.service.log.LogService;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @Author wzl
 * @Date 2018/12/28 11:50
 * @doc 日志拦截
 **/
@Component
public class LogInterceptor  implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Resource
    private LogService logService;

    /**
     * 方法执行前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 方法执行后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*获取缓存中的用户信息*/
        Cookie[] cookies = request.getCookies();
        /*用户名*/
        String userName = null;
        /*遍历cookie*/
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(CommonConstant.CookieConstant.USERNAME.equals(name)){
                userName = cookie.getValue();
                if(StringUtils.isBlank(userName)){
                    return;
                }else{
                    this.saveLog(handler,userName);
                }
                break;
            }
        }
    }


    /**
     * 调用接口保存日志
     * @param handler
     * @param userName
     */
    public void  saveLog(Object handler,String userName){
        // 将handler强转为HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        /*获取方法信息*/
        Method method = handlerMethod.getMethod();
        /*获取方法是否有@LogAccept注解*/
        LogAccept logAccept = method.getAnnotation(LogAccept.class);
        if(logAccept != null){
            /*模块名*/
            String modelName = logAccept.modleName();
            /*行为名*/
            String actionName = logAccept.actionName();
            if(StringUtils.isBlank(modelName)){
                logger.error("modelName can`t`be null");
                return;
            }
            if(StringUtils.isBlank(actionName)){
                logger.error("actionName can`t`be null");
                return;
            }
            /*设置日志对象信息*/
            Log log = new Log();
            log.setModel(modelName);
            log.setAction(actionName);
            log.setUserName(userName);
            MessageResult result = logService.insertLog(log);
            /*插入错误*/
            if(result.isError()){
                logger.error(result.getMessage());
                return;
            }
        }
    }

    /**
     * 方法执行最后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
