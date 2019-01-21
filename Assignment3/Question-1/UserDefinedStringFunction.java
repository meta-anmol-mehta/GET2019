public class UserDefinedStringFunction {

	/*
	 * find the comparison between two string
	 * 
	 * @param firstString an string
	 * 
	 * @param secondString an String
	 * 
	 * @return 1 if both are equal
	 */
	protected int stringCompare(String firstString, String secondString) {
		try {
			for (int i = 0; i < firstString.length(); ++i) {

				if (firstString.charAt(i) != secondString.charAt(i)) {
					return 0;
				}
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return 1;

	}

	/*
	 * find the reverse of given string
	 * 
	 * @param string an string
	 * 
	 * @return reverseString of type string
	 */
	protected String stringReverse(String string) {

		try {
			StringBuilder reverse = new StringBuilder();

			for (int i = string.length(); i > 0; --i) {
				reverse.append(string.charAt(i - 1));
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return reverse.toString();
	}

	/*
	 * find the inversion of case of given string
	 * 
	 * @param string an string
	 * 
	 * @return caseInverted string of type string
	 */
	protected String caseInversion(String string) {

		StringBuilder caseChange = new StringBuilder();

		try {
			int n = string.length();

			int i = 0;
			int character;

			while (n-- != 0) {
				character = string.charAt(i);

				if (character >= 65 && character <= 90) {
					invertedString.append((char) (character + 32));
				} else if (character >= 97 && character <= 122) {
					invertedString.append((char) (character - 32));
				} else if (character == 32) {
					invertedString.append(" ");
				}
				i++;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
		return caseChange.toString();

	}

	/*
	 * find the Longest word in given string
	 * 
	 * @param string an string
	 * 
	 * @return longest of type string
	 */
	protected String LongestWord(String string) {

		int largest = 0;
		StringBuilder word = new StringBuilder();

		try {

			for (int i = 0, j = 0; i < string.length(); i++) {
				if (string.charAt(i) == ' ') {
					if ((i - j) > largest) {
						largest = (i - j);

						word.delete(0, word.length());

						for (int k = j; k < i; k++) {
							word.append(string.charAt(k));
						}

					}
					j = i + 1;
				} else if (string.length() == (i + 1)) {
					if ((i - j) > largest) {
						largest = (i - j);

						word.delete(0, word.length());

						for (int k = j; k < string.length(); k++) {
							word.append(string.charAt(k));
						}
					}
					j = i + 1;
				}
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
		return word.toString();
	}

}
