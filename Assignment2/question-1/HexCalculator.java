import java.util.Scanner;

public class HexCalculator {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		// taking two hexadecimal number in string format as hexNum1 and hexNum2
		String hexNum1, hexNum2;
		// taking choice of user what functionality user want to opt
		int choice;

		System.out.println("Enter First Hexadecimal String");
		hexNum1 = input.next();

		System.out.println("Enter second Hexadecimal String");
		hexNum2 = input.next();

		HexCalc calc = new HexCalc(hexNum1, hexNum2);

		do {
			System.out.println("1.For Add");
			System.out.println("2.For Subtract");
			System.out.println("3.For Multiply");
			System.out.println("4.For Divide");
			System.out.println("5.For Equality");
			System.out.println("6.For Greater");
			System.out.println("7.For Small");
			System.out.println("8 for Exit");
			System.out.println("Enter your choice");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Result=" + calc.addNumber());
				break;
			case 2:
				System.out.println("Result=" + calc.subtractNumber());
				break;
			case 3:
				System.out.println("Result=" + calc.multiplyNumber());
				break;
			case 4:
				System.out.println("Result=" + calc.divideNumber());
				break;
			case 5:
				System.out.println("Result=" + calc.isEqual());
				break;
			case 6:
				System.out.println("Result=" + calc.isGreater());
				break;
			case 7:
				System.out.println("Result=" + calc.isSmall());
				break;
			case 8:
				break;
			default:
				System.out.println("Invalid choice");
			}

		} while (choice != 8);
	}
}
