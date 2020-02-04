package com.house.manager.config;

import com.house.manager.interceptor.backLoginIntercetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**

 * @Create 2020-01-17 7:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("go/to/login").setViewName("/member-login");
        registry.addViewController("go/to/register").setViewName("/member-register");
        registry.addViewController("/backup/go/to/index").setViewName("/index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new backLoginIntercetor()).addPathPatterns("/backup/**");
    }
}
