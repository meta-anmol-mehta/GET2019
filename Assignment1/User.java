public class User {

	private String userName;
	private String userContactNumber;

	User(String userName, String userContactNumber) {

		this.userName = userName;
		this.userContactNumber = userContactNumber;

	}

	void userDisplay() {

		System.out.println("name:" + userName);
		System.out.println("Contact:" + userContactNumber);

	}

}
