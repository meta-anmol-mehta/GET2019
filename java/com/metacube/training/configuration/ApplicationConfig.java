package com.metacube.training.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;

/**
 * configuration class of hibernate
 * @author admin
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.metacube.training")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class ApplicationConfig implements WebMvcConfigurer{

	@Autowired
	Environment env;

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Autowired
	private ApplicationContext applicationContext;
	
	/*
	 * STEP 1 - Create SpringResourceTemplateResolver
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/pages/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
	   InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	   resolver.setOrder(1);
	   resolver.setPrefix("/WEB-INF/pages/");
	   resolver.setSuffix(".jsp");
	   return resolver;
	}
	
	/*
	 * STEP 2 - Create SpringTemplateEngine
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	/*
	 * STEP 3 - Register ThymeleafViewResolver
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
	@Bean
	  public LocalSessionFactoryBean getSessionFactory() {
	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    
	    Properties props = new Properties();
	    
	    // Setting Hibernate properties
	    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

	    factoryBean.setHibernateProperties(props);
	    factoryBean.setAnnotatedClasses(new Class[]{User.class,UserCredential.class});
	    return factoryBean;
	  }

	  @Bean
	  public HibernateTransactionManager getTransactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(getSessionFactory().getObject());
	    return transactionManager;
	  }


}
