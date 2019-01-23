
public class SearchFunc {

	/**
	 * 
	 * @param inputArray    integer array
	 * @param arrayLength   of array
	 * @param searchElement to be found
	 * @return result : position of value in array if value not found return -1
	 */

	protected int linearSearch(int arrayLength, int[] inputArray, int searchElement) {

		if (inputArray.length == 0) {
			throw new AssertionError("Array is empty");
		}
		if (inputArray[arrayLength] == searchElement) {
			return arrayLength;
		} else if (arrayLength == 0) {
			return -1;
		}
		--arrayLength;
		return linearSearch(arrayLength, inputArray, searchElement);

	}

	/**
	 * 
	 * @param inputArray    integer array
	 * @param arrayLength   of array
	 * @param searchElement to be found
	 * @return result : position of value in array if value not found return -1
	 */

	protected int binarySearch(int startIndex, int endIndex, int[] inputArray, int searchElement) {

		int midValue = 0;
		if (inputArray.length == 0) {
			throw new AssertionError("Array is empty");
		}
		if (startIndex <= endIndex) {

			midValue = (startIndex + endIndex) / 2;

			if (inputArray[midValue] == searchElement) {
				return midValue;
			} else if (inputArray[midValue] > searchElement) {
				return binarySearch(startIndex, midValue - 1, inputArray, searchElement);
			} else {
				return binarySearch(midValue + 1, endIndex, inputArray, searchElement);
			}

		} else {
			return -1;
		}

	}

}
