import java.util.Scanner;

public class ShoppingClass {

	private static Scanner input;

	ShoppingClass() {

	}

	public static void main(String[] args) {

		System.out.println("Welcome to the Cart");
		int choice;
		String userName, userContactNumber;
		input = new Scanner(System.in);
		System.out.println("Enter your name");
		userName = input.next();
		System.out.println("Enter your Contact number");
		userContactNumber = input.next();
		Cart newUser = new Cart();
		newUser.initialize();

		do {

			System.out.println("Enter your choice ");
			System.out.println("Enter 1 for AddToCart");
			System.out.println("Enter 2 for UpdateCart");
			System.out.println("Enter 3 for RemoveCart");
			System.out.println("Enter 4 for Billing");
			System.out.println("Enter 5 to Exit Application");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				newUser.addToCart();
				break;
			case 2:
				newUser.updateToCart();
				break;
			case 3:
				newUser.removeFromCart();
				break;
			case 4:
				newUser.billing(userName, userContactNumber);
				break;
			case 5:
				System.out.println("Exited");
				break;
			default:
				System.out.println("invalid choice");
			}

		} while (choice != 5 || choice != 4);
	}

}
