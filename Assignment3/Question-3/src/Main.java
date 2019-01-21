import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice;
		int numberOfStudent;
		double[] grade;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of students");
		numberOfStudent = input.nextInt();
		grade = new double[numberOfStudent];
		for (int i = 0; i < numberOfStudent; ++i) {
			System.out.println("Enter number of student" + (i + 1));
			grade[i] = input.nextInt();
		}

		Marksheet marks = new Marksheet(numberOfStudent, grade);

		do {

			System.out.println("Enter 1 for Average of grade");
			System.out.println("Enter 2 for Maximum grade");
			System.out.println("Enter 3 for Minimum grade");
			System.out.println("Enter 4 for Percentage of students passed");
			System.out.println("Enter 5 for exit");
			System.out.println("Enter your choice");
			choice = input.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Average grade of students" + marks.averageOfGrade());
				break;
			case 2:
				System.out.println("Maximum grade of students" + marks.maximumOfGrade());

				break;
			case 3:
				System.out.println("minimum grade of students" + marks.minimumOfGrade());

				break;
			case 4:
				System.out.println("Percentage of students passed" + marks.studentPassed());

				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 5);
	}

}
