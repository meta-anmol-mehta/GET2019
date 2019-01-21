import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice;
		String first, second;
		Scanner input = new Scanner(System.in);
		UserDefinedStringFunction func = new UserDefinedStringFunction();

		System.out.println("Enter 1 for Compare");
		System.out.println("Enter 2 for reverse");
		System.out.println("Enter 3 for CaseInversion");
		System.out.println("Enter 4 for Longest word in String");
		System.out.println("Enter 5 for exit");

		do {

			System.out.println("Enter your choice");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter first string");
				first = input.nextLine();

				System.out.println("Enter second string");
				input.nextLine();
				second = input.nextLine();

				int isEqual = func.stringCompare(first, second);

				if (isEqual == 1) {
					System.out.println("Strings are equal");
				} else {
					System.out.println("Strings are not equal");
				}
				break;
			case 2:
				System.out.println("Enter any  string for reverse");
				input.nextLine();
				first = input.nextLine();

				System.out.println("Reverse string=" + func.stringReverse(first));
				break;
			case 3:
				System.out.println("Enter any  string for invert");
				input.nextLine();
				first = input.nextLine();
				System.out.println("Invert string=" + func.caseInversion(first));
				break;
			case 4:
				System.out.println("Enter any  string to get largest word");

				input.nextLine();
				first = input.nextLine();
				System.out.println("Largest word=" + func.LongestWord(first));
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 5);
	}

}
