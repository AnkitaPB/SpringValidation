package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan("com")
@Import(DBConfig.class)
public class AppConfig   extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver irvc=new InternalResourceViewResolver();
		irvc.setPrefix("/WEB-INF/jsp");
		irvc.setSuffix(".jsp");
		return irvc;
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/app-resources/**").addResourceLocations("/resources/");
    }    
	
	
    
}
