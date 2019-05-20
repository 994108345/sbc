package cn.wzl.sbc.prod.web.controller.interceptor.config;

import cn.wzl.sbc.prod.web.controller.interceptor.ProdInterceptor;
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
public class ProdWebConfig implements WebMvcConfigurer {
    @Autowired
    private ProdInterceptor prodInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        /**
         * 拦截
         */
        registry.addInterceptor(prodInterceptor).addPathPatterns(this.addPath())
                .excludePathPatterns(this.excludePath());



    }

    /**
     * 需要拦截的路径
     * @return
     */
    public String[] addPath(){
        String[] path = {"/sbc-prod/**"};
        return path;
    }

    /**
     * 不需要拦截的路径
     * @return
     */
    public String[] excludePath(){
        String[] path = {"/sbc-prod/Article/webNo/articleServiceImpl/queryArticleInfo"
                ,"/sbc-prod/Article/webNo/articleServiceImpl/queryArticleAllInfo",
                "/sbc-prod/Article/webNo/articleTypeServiceImpl/queryArticleTypeByPage",
                "/sbc-prod/Article/webNo/**"
        };
        return path;
    }


}
