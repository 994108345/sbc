package cn.wzl.sbc.prod.web.controller.interceptor;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.constant.RestConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.CookieUtil;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 10:26
 * @description：pro的拦截器
 */
@Component
public class ProdInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ProdInterceptor.class);

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MessageResult result = new MessageResult();
        boolean isToken = false;
        /*获取cookie*/
        try {
            /*获取头信息，是否为内部restapi访问,如果是内部请求，直接放行*/
            String restApi = request.getHeader(RestConstant.REST_API_HEADER);
            if(!StringUtils.isBlank(restApi)){
                return true;
            }

            Cookie cookie = CookieUtil.get(request, CommonConstant.CookieConstant.TOKEN);
            String token = cookie.getValue();
            String userInfoStr = (String)redisUtil.getByKey(token);
            UserInfo userInfo = JSONObject.parseObject(userInfoStr,UserInfo.class);
            if(userInfo == null){
                throw new Exception("缺少登陆信息，请先登陆");
            }
            String userName = userInfo.getUserName();
            request.setAttribute(CommonConstant.RequestConstant.USERNAME,userName);
            /*token存在，即重置cookie的token，redis的token和username的存活时间*/
            cookie.setMaxAge(CommonConstant.CookieConstant.LOGIN_OUT_TIME);
            redisUtil.addOutTime(token, RedisConstant.RedisOutTimes.TOKEN_OUT_TIME, TimeUnit.HOURS);
            isToken = true;
        } catch (Exception e) {
            isToken = false;
            log.error("preHandle preHandle has error ...",e);
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
