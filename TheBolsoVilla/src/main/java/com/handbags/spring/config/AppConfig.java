package com.handbags.spring.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.handbags.spring.controller")
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
	
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");

	return viewResolver;
}

@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
}

@Autowired
@Bean(name="multipartResolver")
public CommonsMultipartResolver getResolver() throws IOException{
	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	return resolver;
}

}

