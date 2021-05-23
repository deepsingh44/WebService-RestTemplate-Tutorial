package com.deepsingh44.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.deepsingh44.model.Book;
import com.deepsingh44.model.User;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.deepsingh44" })
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment environment;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/")
				.setCacheControl(CacheControl.maxAge(0, TimeUnit.HOURS).cachePublic());

		registry.addResourceHandler("/books/**").addResourceLocations("/books/")
				.setCacheControl(CacheControl.maxAge(0, TimeUnit.HOURS).cachePublic());

		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.class"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.user"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.pass"));
		System.out.println("Deep database " + dataSource);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		//sessionFactory.setPackagesToScan(new String[] { "com.deepsingh44.model" });
		sessionFactory.setAnnotatedClasses(User.class, Book.class);
		sessionFactory.setHibernateProperties(hibernateProperties());
		System.out.println("deep session " + sessionFactory);
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		System.out.println(properties);
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		System.out.println("transaction " + "hello");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		System.out.println("transaction " + transactionManager);
		return transactionManager;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cm = new CommonsMultipartResolver();
		cm.setMaxUploadSize(100000);
		return cm;
	}

}