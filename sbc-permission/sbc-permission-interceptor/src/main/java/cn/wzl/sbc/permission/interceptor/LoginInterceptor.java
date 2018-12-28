package cn.wzl.sbc.permission.interceptor;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        Cookie[] cookies = request.getCookies();
        /*标签是否有cookie*/
        boolean isCookie = false;
        try {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if(CommonConstant.CookieConstant.TOKEN.equals(name)){
                    String value = cookie.getValue();
                    /*查看redis是否有该key*/
                    String token = (String)redisUtil.getByKey(value);
                    if(token == null){
                        isCookie = false;
                    }else{
                        /*token存在后，生命周期重置*/
                        redisUtil.addWithTime(token,"",1L, TimeUnit.HOURS);
                        isCookie = true;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            log.error("请求redis报错：" + e.getMessage(),e);
        }
        if(!isCookie){
            String origin = request.getHeader("Origin");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            PrintWriter writer = response.getWriter();
            MessageResult result = new MessageResult();
            result.setStatus(ReturnResultEnum.ERROR.getStatus());
            result.setMessage("缺少登陆信息，请先登陆");
            String jsonData = JSON.toJSONString(result);
            char[] characters = jsonData.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                writer.append(characters[i]);
            }
        }
        return isCookie;
    }
}
