package cn.wzl.sbc.permission.interceptor;

import cn.wzl.sbc.common.annotation.LogAccept;
import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.util.CookieUtil;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.model.permission.Log;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.permission.service.log.LogService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Author wzl
 * @Date 2018/12/28 11:50
 * @doc 日志拦截
 **/
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Resource
    private LogService logService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 方法执行前
     *
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
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            Cookie cookie = CookieUtil.get(request, CommonConstant.CookieConstant.TOKEN);
            String token = cookie.getValue();
            String userName = (String) redisUtil.getByKey(token);
            if(StringUtils.isBlank(userName)){
                throw new Exception("redis中的userName不存在");
            }
            String userStr = (String) redisUtil.getByKey(userName);

            if(StringUtils.isBlank(userStr)){
                throw new Exception("redis中的userInfo不存在");
            }
            UserInfo userInfo = JSON.parseObject(userStr,UserInfo.class);
            /*调用接口保存日志*/
            saveLog(handler, userInfo);
        } catch (Exception e) {
            logger.error("logInterceptor postHandle", e);
        }
    }


    /**
     * 调用接口保存日志
     *
     * @param handler
     * @param userName
     */
    public void saveLog(Object handler, UserInfo userName) {
        // 将handler强转为HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        /*获取方法信息*/
        Method method = handlerMethod.getMethod();
        /*获取方法是否有@LogAccept注解*/
        LogAccept logAccept = method.getAnnotation(LogAccept.class);
        if (logAccept != null) {
            /*模块名*/
            String modelName = logAccept.modleName();
            /*行为名*/
            String actionName = logAccept.actionName();
            if (StringUtils.isBlank(modelName)) {
                logger.error("modelName can`t be null");
                return;
            }
            if (StringUtils.isBlank(actionName)) {
                logger.error("actionName can`t be null");
                return;
            }
            /*设置日志对象信息*/
            Log log = new Log();
            log.setModel(modelName);
            log.setAction(actionName);
            log.setUserName(userName.getUserName());
            MessageResult result = logService.insertLog(log);
            /*插入错误*/
            if (result.isError()) {
                logger.error(result.getMessage());
                return;
            }
        }
    }

    /**
     * 方法执行最后
     *
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
