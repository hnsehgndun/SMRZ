package com.crm.config;

import com.crm.converter.DateConverter;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyConfig extends WebMvcConfigurationSupport {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Bean
    public PageHelper getPageHelper(){
        return new PageHelper();
    }


}
