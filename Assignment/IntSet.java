import java.util.ArrayList;

/**
 * 
 * An immutable class to implement sets in range 1-1000
 * 
 * @author Anmol
 *
 */

public final class IntSet {

	private final int[] inputSet;

	private final int MAX_VALUE = 1000;

	/**
	 * 
	 * constructor of the class
	 * 
	 * @param array
	 *            to initialize
	 */

	public IntSet(int[] inputSet) {

		this.inputSet = (int[]) inputSet.clone();

	}

	/**
	 * 
	 * the number to check for being member of set
	 * 
	 * @param inputValue
	 *            an integer
	 * 
	 * @return true if member
	 */

	public boolean isMember(int inputValue) {

		if (inputSet.length == 0) {
			throw new AssertionError("Array is empty");
		}

		for (int i = 0; i < inputSet.length; ++i) {
			if (inputSet[i] == inputValue) {
				return true;
			}
		}

		return false;

	}

	/**
	 * 
	 * Gives size of set
	 * 
	 * @return returns length of set array
	 */

	public int setSize() {

		if (inputSet.length == 0) {
			throw new AssertionError("Array is empty");
		}

		return inputSet.length;

	}

	/**
	 * 
	 * subset anotherSet
	 * 
	 * @param takes
	 *            the subset to check
	 * 
	 * @return returns true if contains subset else false
	 */

	public boolean isSubSet(IntSet anotherSet) {

		if (inputSet.length == 0 || anotherSet.inputSet.length == 0) {
			throw new AssertionError("Array is empty");
		}

		int countValue = 0;

		for (int i = 0; i < inputSet.length; ++i) {
			countValue = 0;
			for (int j = 0; j < anotherSet.inputSet.length; ++j) {
				if (anotherSet.inputSet[j] == inputSet[i + countValue]) {
					++countValue;
				}
			}
			if (countValue == anotherSet.inputSet.length) {
				return true;
			}
		}

		return false;

	}

	/**
	 * 
	 * Calculates compliment set from the universal set with current set
	 * 
	 * @return Returns array of compliment set
	 */

	public int[] complementedSet() {

		if (inputSet.length == 0) {
			throw new AssertionError("Array is empty");
		}

		int complicatedArray[] = new int[MAX_VALUE];

		for (int i = 0, j = 0; i < MAX_VALUE; ++i) {

			if (isMember(i)) {
				continue;
			} else {
				complicatedArray[j] = i;
				++j;
			}

		}

		return complicatedArray;

	}

	/**
	 * 
	 * Calculate union of two sets
	 * 
	 * @param Takes
	 *            a set to get union with the instance variable set
	 * 
	 * @return Returns the arrayList of union
	 */

	public ArrayList<Integer> unionOfSet(IntSet AnotherinputSet) {

		if (inputSet.length == 0) {
			throw new AssertionError("Array is empty");
		}

		ArrayList<Integer> unionSet = new ArrayList<Integer>();

		for (int i = 0; i < inputSet.length; ++i) {
			unionSet.add(inputSet[i]);
		}
		for (int i = 0; i < AnotherinputSet.inputSet.length; ++i) {

			if (isMember(AnotherinputSet.inputSet[i])) {
				continue;
			} else {
				unionSet.add(inputSet[i]);
			}
		}

		return unionSet;

	}

}
