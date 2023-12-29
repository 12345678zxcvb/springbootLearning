package com.situ.springboot.config;

import com.situ.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        //把登录的拦截器配置上才能起作用
        // addPathPatterns("/**") 拦截器拦截所有的请求
        // excludePathPatterns 代表哪些请求不需要拦截
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/toLogin", "/user/login", "/auth/code", "/static/**");
    }
}
