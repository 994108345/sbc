package cn.wzl.sbc.permission.web.controller.config;

import cn.wzl.sbc.permission.web.controller.intercept.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author wzl
 * @Date 2018/12/24 11:24
 * @doc 路由拦截器配置类
 **/

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addPathPatterns：拦截哪些路径("/**":代表拦截所有路径);
         * excludePathPatterns：不拦截哪些路径;
         *
         */
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/sbc-permission/Login/login","/sbc-permission/Register/register");
    }
}
