
public class NumberCalculations {

	int checkValue = 1;

	/**
	 * @param num1 integer value
	 * @param num2 integer value
	 * @return HCF of num1 and num2
	 */

	protected int calculateHCF(int num1, int num2) {

		if (num2 <= 0) {
			throw new ArithmeticException("Dividing by zero or negative number");
		} else {
			if (num1 % num2 == 0) {
				return num2;
			}
			return calculateHCF(num2, num1 % num2);
		}
	}

	/**
	 * @param num1 integer value
	 * @param num2 integer value
	 * @return LCM of num1 and num2
	 */

	protected int calculateLCM(int num1, int num2) {

		if (num2 <= 0 || num1 <= 0) {
			throw new ArithmeticException("Number is not positive");
		}

		if (checkValue % num1 == 0 && checkValue % num2 == 0) {
			return checkValue;
		}
		checkValue++;
		calculateLCM(num1, num2);
		return checkValue;

	}

}
