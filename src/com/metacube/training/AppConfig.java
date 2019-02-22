package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * AppCOnfig is used to config twitter class for creating its object using spring
 * @author admin
 *
 */

@Configuration
public class AppConfig {

	
	// Create Object of EmailService with autoWire 
	@Bean
	public TwitterService twitterService(String message ,String receiver){
		return new TwitterService(message,receiver);
	}
	
	
}
