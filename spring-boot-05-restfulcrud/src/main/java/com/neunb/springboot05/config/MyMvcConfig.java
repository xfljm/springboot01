package com.neunb.springboot05.config;

import com.neunb.springboot05.component.LoginhandlerIntercepter;
import com.neunb.springboot05.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
//        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/").setViewName("login");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginhandlerIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
                //spring boot已经处理好了静态资源，所以不需要排除js或css
            }
        };
        return adapter;
    }

    @Bean  //需要添加到容器，才能将自定义的生效
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
