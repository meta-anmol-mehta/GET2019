import java.util.Scanner;


public class User {

	String user_Name;
	String user_Contact_Number;
	
	User(){
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your name");
		user_Name=s.next();
		System.out.println("Enter your Contact number");
		user_Contact_Number=s.next();	
	}
	
	void User_display(){
		
		System.out.println("name:"+user_Name);
		System.out.println("Contact:"+user_Contact_Number);
		
	}
	
}
