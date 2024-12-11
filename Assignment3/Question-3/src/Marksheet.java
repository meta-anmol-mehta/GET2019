public class Marksheet {

	private int numberOfStudent;
	private double[] grade;

	protected Marksheet(int numberOfStudent, double[] grade) {

		this.numberOfStudent = numberOfStudent;
		this.grade = grade;
	}

	/*
	 * find average of a grade
	 * 
	 * @param list :List of marksheet of student whose average grade to be
	 * calculated
	 * 
	 * @return result : average of the grades of list
	 */

	protected double averageOfGrade() {

		try {

			double averageOfGrade = 0.0,sum=0.0;

			for (double particularGrade : grade) {

				sum = sum + particularGrade;

			}

			averageOfGrade = sum / numberOfStudent;

		}

		catch (Exception e) {
			System.out.println(e);
		}

		return averageOfGrade;

	}

	/*
	 * find maximum grade in the List
	 * 
	 * @param list :List of marksheet of student
	 * 
	 * @return result : Maximum grade of given list
	 */

	protected double maximumOfGrade() {

		try {
			double maxOfGrade = 0.0;

			for (double particularGrade : grade) {

				if (maxOfGrade < particularGrade) {
					maxOfGrade = particularGrade;
				}

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return maxOfGrade;

	}

	/*
	 * find minimum grade in the List
	 * 
	 * @param list :List of marksheet of student
	 * 
	 * @return result : Minimum grade of given list
	 */

	protected double minimumOfGrade() {

		try {
			double minOfGrade = grade[0];

			for (double particularGrade : grade) {

				if (minOfGrade > particularGrade) {
					minOfGrade = particularGrade;
				}

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return minOfGrade;

	}

	/*
	 * find percentage of student passed
	 * 
	 * @param list :List of marksheet of student
	 * 
	 * @return result : List of student who are Passed
	 */

	protected double studentPassed() {
		try {
			int passedStudent = 0;
			for (double particularGrade : grade) {

				if (particularGrade >= 40) {
					passedStudent++;
				}

			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		return ((((double) passedStudent) / numberOfStudent) * 100);

	}
}
