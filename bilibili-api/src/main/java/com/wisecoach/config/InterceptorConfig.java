package com.wisecoach.config;

import com.wisecoach.interceptor.GlobalAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    GlobalAuthInterceptor globalAuthInterceptor(){
        return new GlobalAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalAuthInterceptor()).addPathPatterns("/**");
    }
}
