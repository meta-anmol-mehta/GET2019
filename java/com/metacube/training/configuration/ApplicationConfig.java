package com.metacube.training.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * configuration class of hibernate
 * 
 * @author admin
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.metacube.training")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class ApplicationConfig implements WebMvcConfigurer {
	 @Autowired
	    Environment env;

	    private final String URL = "url";
	    private final String USER = "dbuser";
	    private final String DRIVER = "driver";
	    private final String PASSWORD = "dbpassword";

	    @Autowired
	    private ApplicationContext applicationContext;

	    @Bean
	    public InternalResourceViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/pages/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean
	                .setPersistenceProviderClass(HibernatePersistenceProvider.class);
	        entityManagerFactoryBean.setPackagesToScan(env
	                .getProperty("entitymanager.packages.to.scan"));
	        entityManagerFactoryBean.setJpaProperties(hibProperties());

	        return entityManagerFactoryBean;
	    }

	    private Properties hibProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect",
	                env.getProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql",
	                env.getProperty("hibernate.show_sql"));

	        return properties;
	    }

	    @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory()
	                .getObject());

	        return transactionManager;
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


}
