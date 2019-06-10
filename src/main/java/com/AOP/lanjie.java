package com.AOP;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class lanjie implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Dlulanjie())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/user/login");
    }

}
