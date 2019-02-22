package com.metacube.training;

/**
 * email service is used to create email to send message to receiver
 * @author admin
 *
 */

public class EmailService implements MessageService {

	
	 /**
     * method to print message by his receiver name 
     * @param message to be send 
     * @param receiver address of receiver
     */
	
	@Override
	public void sendMessage(String message, String receiver) {
		
		System.out.println("Hello "+receiver+"\n"+message);
		
	}

	

}
