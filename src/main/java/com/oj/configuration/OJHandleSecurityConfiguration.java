package com.oj.configuration;

import com.oj.security.OJHandleSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lixu
 * @Time 2019年3月12日 13点47分
 * @Description 自定义拦截器OJHandleSecurity配置类
 */

@Configuration
public class OJHandleSecurityConfiguration implements WebMvcConfigurer {
//    @Resource
//    private OJHandleSecurity ojHandleSecurity;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new OJHandleSecurity()).addPathPatterns("/**").excludePathPatterns("/login", "/", "/demo/*","/css/*", "/js/*", "fonts/*");
//        registry.addInterceptor(new OJHandleSecurity()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{"/login", "/", "/css/**", "/js/**", "/fonts/**"};
        registry.addInterceptor(new OJHandleSecurity()).addPathPatterns("/**").excludePathPatterns(excludes);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}
