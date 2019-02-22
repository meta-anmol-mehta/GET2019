package com.metacube.training;

/**
 * MessageService is interface used to create email to send message to receiver
 * @author admin
 *
 */


public interface MessageService {

	/**
     * 
     * @param message to be send 
     * @param receiver address of receiver
     */
	
	public void sendMessage(String message,String receiver);
}
