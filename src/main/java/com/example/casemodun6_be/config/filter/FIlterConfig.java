package com.example.casemodun6_be.config.filter;

import com.example.casemodun6_be.controller.FilterControler;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FIlterConfig {
    @Bean
    public FilterRegistrationBean<FilterControler> registrationBean(){
        FilterRegistrationBean<FilterControler> register =
                new FilterRegistrationBean<>();

        register.setFilter(new FilterControler());
        register.addUrlPatterns("/Login");
        return register;
    }
}
