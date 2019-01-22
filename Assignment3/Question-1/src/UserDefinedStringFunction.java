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

			if (firstString.length() == secondString.length()) {
				for (int i = 0; i < firstString.length(); ++i) {

					if (firstString.charAt(i) != secondString.charAt(i)) {
						return 0;
					}
				}
			} else {
				return 0;
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
	protected String stringReverse(String inputString) {

		if (inputString.length == 0) {
			throw new NullPointerException("String is empty");
		} else {

			try {
				StringBuilder reverseString = new StringBuilder();

				for (int i = inputString.length(); i > 0; --i) {
					reverseString.append(inputString.charAt(i - 1));
				}
				return reverseString.toString();
			}

			catch (Exception e) {
				System.out.println(e);
				return null;
			}

		}

		
	}

	/*
	 * find the inversion of case of given string
	 * 
	 * @param string an string
	 * 
	 * @return caseInverted string of type string
	 */
	protected String caseInversion(String inputString) {

		StringBuilder caseChange = new StringBuilder();

		if (inputString.length == 0) {
			throw new NullPointerException("String is empty");
		} else {

			try {
				int n = inputString.length();

				int i = 0;
				int inputCharacter;

				while (n-- != 0) {
					inputCharacter = string.charAt(i);

					if (inputCharacter >= 'A' && inputCharacter <= 'Z') {
						invertedString.append((char) (inputCharacter + 32));
					} else if (inputCharacter >= 'a' && inputCharacter <= 'z') {
						invertedString.append((char) (inputCharacter - 32));
					} else if (inputCharacter == 32) {
						invertedString.append(" ");
					}
					i++;
				}

			}

			catch (Exception e) {
				System.out.println(e);
			}
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
	protected String longestWord(String inputString) {

		String largest="";
		StringBuilder word = new StringBuilder();
		if (inputString.length == 0) {
			throw new NullPointerException("String is empty");
		} else {
			try {

				String[] word=s.split(" ");
				  for(int i=0;i<word.length;i++){
				     if(word[i].length()>=longest.length()){
				       longest=word[i];
				     }
				  }

			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
		return largest;
	}

}
