package com.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {

	@Autowired
	Environment env;
	@Bean
	public HibernateTemplate hibernateTemplate()
	{
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	private SessionFactory sessionFactory() {
        LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setPackagesToScan("com.bean");
        lsfb.setHibernateProperties(hibernateProperties());
        
        try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb.getObject();
		
	}
	private Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
		
		return properties;
	}
	@Bean
	private DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("database.driver"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.root"));
		dataSource.setPassword(env.getProperty("database.password"));
		
		return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibernateTrans()
	{
		return new HibernateTransactionManager(sessionFactory());
	}
	
	 
}
