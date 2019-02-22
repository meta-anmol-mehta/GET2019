package com.metacube.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	
	public static void main(String args[]){
			
		ApplicationContext factory=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
//      create object of Email Service using XML with  Spring annotations for auto-wiring
		EmailService email=(EmailService)factory.getBean("email");
		email.sendMessage("how are you?", "anmol");
		
		ApplicationContext twitterFactory=new AnnotationConfigApplicationContext(AppConfig.class);
		
//      create object of Twitter using java with spring annotation without annotation and wiring
		
		TwitterService service=(TwitterService)twitterFactory.getBean("twitterService");
		service.sendMessage("how are you?", "anmol");
	}
	
}
