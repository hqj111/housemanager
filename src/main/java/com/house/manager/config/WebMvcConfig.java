package com.house.manager.config;

import com.house.manager.interceptor.backLoginIntercetor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Create 2020-01-17 7:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.filepath}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + filePath,
                "classpath:static/images/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("go/to/login").setViewName("/member-login");
        registry.addViewController("go/to/register").setViewName("/member-register");
        registry.addViewController("/backup/go/to/index").setViewName("/index");
        registry.addViewController("/go/to/file").setViewName("/file");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new backLoginIntercetor()).addPathPatterns("/backup/**");
    }
}
