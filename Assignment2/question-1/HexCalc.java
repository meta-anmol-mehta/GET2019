import java.util.HashMap;
import java.util.Map;

public class HexCalc {

	private String hexNum1;
	private String hexNum2;
	private int decimalNum1, decimalNum2;

	// Constructor to initialize values of dataMember of class HexCalc

	protected HexCalc(String hexNum1, String hexNum2) {

		this.hexNum1 = hexNum1;
		this.hexNum2 = hexNum2;

	}

	// addNumber() method add two hexadecimalNumber
	// in this method we are converting two hexadecimal number into decimal
	// number then adding two decimal number then converting back to hexadecimal
	// number and storing in string format and returning them

	protected String addNumber() {
		
		decimalNum1 = Integer.parseInt(hexNum1, 16);

		decimalNum2 = Integer.parseInt(hexNum2, 16);

		int sum = decimalNum1 + decimalNum2;

		String sumToHexaDecimal = Integer.toHexString(sum);

		return sumToHexaDecimal;

	}

	// subtractNumber() method add two hexadecimalNumber
	// in this method we are converting two hexadecimal number into decimal
	// number then subtracting two decimal number then converting back to
	// hexadecimal
	// number and storing in string format and returning them

	protected String subtractNumber() {
		decimalNum1 = Integer.parseInt(hexNum1, 16);

		decimalNum2 = Integer.parseInt(hexNum2, 16);

		int difference = decimalNum1 - decimalNum2;

		String diffToHexaDecimal = Integer.toHexString(difference);

		return diffToHexaDecimal;

	}

	// multiplyNumber() method add two hexadecimalNumber
	// in this method we are converting two hexadecimal number into decimal
	// number then multiplying two decimal number then converting back to
	// hexadecimal
	// number and storing in string format and returning them
	protected String multiplyNumber() {

		decimalNum1 = Integer.parseInt(hexNum1, 16);

		decimalNum2 = Integer.parseInt(hexNum2, 16);

		int multiply = decimalNum1 * decimalNum2;

		String multiplyToHexaDecimal = Integer.toHexString(multiply);

		return multiplyToHexaDecimal;

	}

	// divideNumber() method add two hexadecimalNumber
	// in this method we are converting two hexadecimal number into decimal
	// number then dividing two decimal number then converting back to
	// hexadecimal
	// number and storing in string format and returning them
	protected String divideNumber() {

		decimalNum1 = Integer.parseInt(hexNum1, 16);

		decimalNum2 = Integer.parseInt(hexNum2, 16);

		int quotient = decimalNum1 / decimalNum2;

		int reminder = decimalNum1 % decimalNum2;

		StringBuilder doubleToHexaDecimal = new StringBuilder();

		doubleToHexaDecimal.append(Integer.toHexString(quotient));
		doubleToHexaDecimal.append(",");
		doubleToHexaDecimal.append(Integer.toHexString(reminder));

		return doubleToHexaDecimal.toString();

	}

	protected String addNumber(int base) {

		try {
			decimalNum1 = Integer.parseInt(hexNum1, base);

			decimalNum2 = Integer.parseInt(hexNum2, base);

			int sum = decimalNum1 + decimalNum2;

			String sumToHexaDecimal;

			if (base == 8) {
				sumToHexaDecimal = Integer.toOctalString(sum);
				return sumToHexaDecimal;
			} else if (base == 2) {
				sumToHexaDecimal = Integer.toOctalString(sum);
				return sumToHexaDecimal;
			} else if (base == 10) {
				return String.valueOf(sum);
			}
		} catch (NumberFormatException e) { // if any number format exception
											// occur then it may be caught
			System.out.print("Wrong base!");
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;

	}

	protected String subtractNumber(int base) {

		try {
			decimalNum1 = Integer.parseInt(hexNum1, base);

			decimalNum2 = Integer.parseInt(hexNum2, base);

			int difference = decimalNum1 - decimalNum2;

			String diffToHexa;

			if (base == 8) {
				diffToHexa = Integer.toOctalString(difference);
				return diffToHexa;
			} else if (base == 2) {
				diffToHexa = Integer.toOctalString(difference);
				return diffToHexa;
			} else if (base == 10) {
				return String.valueOf(difference);
			}
		} catch (NumberFormatException e) { // if any number format exception
											// occur then it may be caught
			System.out.print("Wrong base!");
		} catch (Exception e) {
			System.out.print(e);
		}

		return null;

	}

	protected String multiplyNumber(int base) {

		try {
			decimalNum1 = Integer.parseInt(hexNum1, base);

			decimalNum2 = Integer.parseInt(hexNum2, base);

			int multiply = decimalNum1 * decimalNum2;

			String multiToHexa;

			if (base == 8) {
				multiToHexa = Integer.toOctalString(multiply);
				return multiToHexa;
			} else if (base == 2) {
				multiToHexa = Integer.toOctalString(multiply);
				return multiToHexa;
			} else if (base == 10) {
				return String.valueOf(multiply);
			}
		} catch (NumberFormatException e) { // if any number format exception
											// occur then it may be caught
			System.out.print("Wrong base!");
		} catch (Exception e) {
			System.out.print(e);
		}

		return null;

	}

	protected String divideNumber(int base) {
		try {
			decimalNum1 = Integer.parseInt(hexNum1, base);

			decimalNum2 = Integer.parseInt(hexNum2, base);

			int quotient = decimalNum1 / decimalNum2;

			int reminder = decimalNum1 % decimalNum2;

			StringBuilder divideToHexaDecimal = new StringBuilder();

			if (base == 8) {
				divideToHexaDecimal.append(Integer.toHexString(quotient));
				divideToHexaDecimal.append(",");
				divideToHexaDecimal.append(Integer.toHexString(reminder));
				return divideToHexaDecimal.toString();
			} else if (base == 2) {
				divideToHexaDecimal.append(Integer.toHexString(quotient));
				divideToHexaDecimal.append(",");
				divideToHexaDecimal.append(Integer.toHexString(reminder));
				return divideToHexaDecimal.toString();
			} else if (base == 10) {
				divideToHexaDecimal.append(Integer.toString(quotient));
				divideToHexaDecimal.append(",");
				divideToHexaDecimal.append(Integer.toString(reminder));
				return divideToHexaDecimal.toString();
			}
		} catch (NumberFormatException e) { // if any number format exception
											// occur then it may be caught
			System.out.print("Wrong base!");
		} catch (Exception e) {
			System.out.print(e);
		}

		return null;

	}

	// checking whether two strings are equal are not
	protected boolean isEqual() {
		String newHexNum1 = hexNum1.toLowerCase();

		String newHexNum2 = hexNum2.toLowerCase();
		for (int i = 0; i < hexNum1.length(); ++i) {

			if (newHexNum1.charAt(i) != newHexNum2.charAt(i)) {
				return false;
			}

		}

		return true;
	}

	// checking whether first string is greater or not
	protected boolean isGreater() {
		String newHexNum1 = hexNum1.toLowerCase();

		String newHexNum2 = hexNum2.toLowerCase();
		for (int i = 0; i < hexNum1.length(); ++i) {

			if (newHexNum1.charAt(i) > newHexNum2.charAt(i)) {
				return true;
			}

		}

		return false;
	}

	// checking whether first string is smaller or not
	protected boolean isSmall() {

		String newHexNum1 = hexNum1.toLowerCase();

		String newHexNum2 = hexNum2.toLowerCase();
		for (int i = 0; i < hexNum1.length(); ++i) {

			if (newHexNum1.charAt(i) < newHexNum2.charAt(i)) {
				return true;
			}

		}

		return false;
	}

	protected static int toDecimal(String hexValue) {
		int desiValue = 0;
		int index, digitIndex = 0;

		for (index = hexValue.length() - 1; index >= 0; index--) {
			if (hexValue.charAt(index) >= '0' && hexValue.charAt(index) <= '9')
				desiValue += (hexValue.charAt(index) - 48)
						* Math.pow(16, digitIndex);
			else if (hexValue.charAt(index) >= 'A'
					&& hexValue.charAt(index) <= 'F')
				desiValue += (hexValue.charAt(index) - 55)
						* Math.pow(16, digitIndex);
			;
			digitIndex++;
		}
		return desiValue;
	}

	protected String toHexa(int desiValue) {
		String hexValue = "";
		String reverse = "";

		if (desiValue == 0)
			return "0";

		while (desiValue != 0) {
			int reminder = 0;

			reminder = desiValue % 16; // storing remainder in reminder
										// variable.

			if (reminder < 10) // check if reminder < 10
				hexValue += ((char) (reminder + 48));
			else
				hexValue += ((char) (reminder + 55));

			desiValue = desiValue / 16;
		}

		for (int i = hexValue.length() - 1; i >= 0; i--) {
			reverse = reverse + hexValue.charAt(i);
		}
		return reverse;
	}

	protected Boolean isValid(String hexNum){
		String pattern1 = "^[0-9A-Fa-f]+$";
		if(hexNum.matches(pattern1)){
			return true;
		}
		else{
			return false;
		}
	}
	
}
