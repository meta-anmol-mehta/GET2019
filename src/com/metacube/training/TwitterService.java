package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * twitter service is used to send message to receiver via twitter
 * @author admin
 *
 */


public class TwitterService implements MessageService{

	
	private String message;
	
	private String receiver;
	
	 /**
     * Constructor that assign value to  message and receiver by auto-wiring
     * @param message to be send (auto wired) 
     * @param receiver address of receiver (auto wired)
     */
	@Autowired
	public TwitterService(String message, String receiver) {
		super();
		this.message = message;
		this.receiver = receiver;
	}

	/**
     * method to print message by his receiver name 
     * @param message to be send 
     * @param receiver address of receiver 
     */
	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
	
		System.out.println("Hello "+this.getReceiver()+"\n"+this.getMessage());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


}
