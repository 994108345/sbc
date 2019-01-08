package cn.wzl.sbc.permission.interceptor;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.CookieUtil;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.common.util.SessionUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import com.alibaba.fastjson.JSON;
import com.netflix.discovery.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Author wzl
 * @Date 2018/12/24 11:22
 * @doc 登陆拦截
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MessageResult result = new MessageResult();
        boolean isToken = false;
        /*获取session中的session*/
        try {
            Cookie cookie = CookieUtil.get(request, CommonConstant.CookieConstant.TOKEN);
            String token = cookie.getValue();
            String userName = (String)redisUtil.getByKey(token);
            /*token存在，即重置cookie的token，redis的token和username的存活时间*/
            cookie.setMaxAge(CommonConstant.CookieConstant.LOGIN_OUT_TIME);
            redisUtil.addOutTime(token,RedisConstant.RedisOutTimes.TOKEN_OUT_TIME,TimeUnit.HOURS);
            redisUtil.addOutTime(userName,RedisConstant.RedisOutTimes.TOKEN_OUT_TIME,TimeUnit.HOURS);
            isToken = true;
        } catch (Exception e) {
            isToken = false;
            log.error("loginInterceptor preHandle",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"缺少登陆信息，请先登陆");
        }
        if(!isToken){
            /*token不存在，设置返回值*/
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            PrintWriter writer = response.getWriter();
            String jsonData = JSON.toJSONString(result);
            writer.write(jsonData);
        }
        return isToken;
    }
}
