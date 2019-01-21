import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

	private static ArrayList<Product> ProductList;
	private ArrayList<Product> ShoppingList;
	private Scanner input;

	Cart() {
		ProductList = new ArrayList<Product>();
		input = new Scanner(System.in);
		ShoppingList = new ArrayList<Product>();
	}

	void initialize() {
		Product product = new Product("Soap", 25.0, 0);
		ProductList.add(product);
		product = new Product("Brush", 20.0, 0);
		ProductList.add(product);
		product = new Product("Paste", 40.0, 0);
		ProductList.add(product);
		product = new Product("Lotion", 50.0, 0);
		ProductList.add(product);
		product = new Product("Oil", 95.0, 0);
		ProductList.add(product);
	}

	void addToCart() {

		int index = 1;
		System.out.println("Available Products!");
		for (Product product : ProductList) {
			System.out.print(index);
			product.productDisplay();
			index++;
		}

		System.out.println("Enter your choice for purchasing");
		int choice = input.nextInt();
		System.out.println("Enter the quantity you want to add");
		int quantity = input.nextInt();

		ProductList.get(choice - 1).productQuantity = quantity;

		ShoppingList.add(ProductList.get(choice - 1));

		System.out.println("Item Added");

	}

	void removeFromCart() {
		if (!ShoppingList.isEmpty()) {
			System.out.println("Enter your choice for remove");
			int index = 1;
			for (Product product : ShoppingList) {
				System.out.print(index);
				product.productDisplay();
				index++;
			}

			int choice = input.nextInt();

			ShoppingList.remove(choice - 1);
			System.out.println("Item removed");
		} else {
			System.out.println("Cart is empty");
		}

	}

	void updateToCart() {
		if (!ShoppingList.isEmpty()) {
			System.out.println("Enter your choice for update");

			for (Product product : ShoppingList) {
				product.productDisplay();
			}

			int choice = input.nextInt();

			System.out.println("Enter the quantity you want to update");
			int quantity = input.nextInt();
			ShoppingList.get(choice - 1).productQuantity = quantity;
			System.out.println("Item Updated");
		} else {
			System.out.println("Cart is empty");
		}

	}

	void billing(String userName, String userContactNumber) {
		if (!ShoppingList.isEmpty()) {
			User user = new User(userName, userContactNumber);
			double total = 0;
			System.out.println("Generating bill!");
			user.userDisplay();

			for (Product product : ShoppingList) {
				total += product.productQuantity * product.productPrice;
			}
			System.out.println("Total amount=" + total);
		} else {
			System.out.println("Cart is empty");
		}
	}

}
