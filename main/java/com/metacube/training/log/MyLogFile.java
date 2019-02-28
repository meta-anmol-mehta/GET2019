package com.metacube.training.log;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * class for storing all the logs and exception in a file
 * @author admin
 *
 */

public  class MyLogFile {

	public static void writeToFile(String message){
		
		try {
			Files.write(Paths.get("MyLogs.txt"), message.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
