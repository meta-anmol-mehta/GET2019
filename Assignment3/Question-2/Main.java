import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice;
		double width, height;
		Scanner input = new Scanner(System.in);
		Area calculate = new Area();
		System.out.println("Enter 1 for Triangle Area");
		System.out.println("Enter 2 for Rectangle Area");
		System.out.println("Enter 3 for Circle Area");
		System.out.println("Enter 4 for Square Area");
		System.out.println("Enter 5 for exit");

		do {

			System.out.println("Enter your choice");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter width of triangle");
				width = Double.parseDouble(input.next());

				System.out.println("Enter height of triangle");
				height = Double.parseDouble(input.next());
				calculate.triangleArea(width, height);
				calculate.display("Triangle");
				break;
			case 2:
				System.out.println("Enter width of rectangle");
				width = Double.parseDouble(input.next());

				System.out.println("Enter height of rectangle");

				height = Double.parseDouble(input.next());
				calculate.rectangleArea(width, height);
				calculate.display("Rectangle");
				break;
			case 3:
				System.out.println("Enter width of circle");
				width = Double.parseDouble(input.next());
				calculate.circleArea(width);
				calculate.display("Circle");
				break;
			case 4:
				System.out.println("Enter width of triangle");

				width = Double.parseDouble(input.next());
				calculate.squareArea(width);
				calculate.display("Square");
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 5);
	}

}
