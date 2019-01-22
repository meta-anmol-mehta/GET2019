import java.util.EmptyStackException;

import org.junit.experimental.max.MaxCore;

/**
 * 
 * @author Anmol mehta
 * 
 * @param elementsOfArray that stores elements of array of type integer
 * 
 * @param arrayLength stores length of array 
 *
 */

public class ArrOperation extends Exception {

	private int[] elementsOfArray;
	private int arrayLength;

	protected ArrOperation(int[] arrayOfNumbers) {

		this.elementsOfArray = arrayOfNumbers;
		this.arrayLength = arrayOfNumbers.length;
	}

	/**
	 * find out the maximum mirror section in Array
	 * 
	 * @param array
	 *            of positive integers
	 * 
	 * @throws assertion
	 *             error if array is empty
	 * 
	 * 
	 * @return size of mirror section
	 * 
	 */

	protected int maxMirrorSection() {

		int maxMirrorIndex = 0;

		if (arrayLength == 0) {
			throw new AssertionError("Array is Empty");
		} else {
			for (int i = 0; i < arrayLength; i++) {
				int count = 0;
				for (int j = arrayLength - 1; j >= 0 && i + count < arrayLength; j--) {
					if (elementsOfArray[i + count] == elementsOfArray[j]) {
						count++;
					} else {

						count = 0;
					}
				}

				maxMirrorIndex = Math.max(maxMirrorIndex, count);
			}
		}
		return maxMirrorIndex;

	}

	/**
	 * find out the number of clumps in Array
	 * 
	 * @param array
	 *            of positive integers
	 * 
	 * @throws assertion
	 *             error if array is empty
	 * 
	 * @return no of clumps in array
	 * 
	 */

	protected int countClumps() {

		int noOfClumps = 0;
		boolean match = false;

		if (arrayLength == 0) {
			throw new AssertionError("Array is Empty");
		} else {

			for (int i = 0; i < arrayLength - 1; ++i) {

				if (elementsOfArray[i] == elementsOfArray[i + 1] && !match) {
					match = true;
					++noOfClumps;
				} else if (elementsOfArray[i] != elementsOfArray[i + 1]) {
					match = false;
				}

			}
		}
		return noOfClumps;

	}

	/**
	 * forming an array in which all the x value in array is followed by y
	 * 
	 * @param an
	 *            integer x and integer y
	 * 
	 * @param array
	 *            of positive integers
	 * 
	 * @throws assertion
	 *             error if array is empty
	 * @throws assertion
	 *             error if x at last position
	 * @throws assertion
	 *             error if x and y occurance are not same
	 * 
	 * @return array with x value followed by y
	 * 
	 */
	public int[] fixXy(int x, int y) {
		
		int flag=0;
		

		if (arrayLength == 0) {
			throw new AssertionError("Array is Empty");
		}
		else if(elementsOfArray[arrayLength-1]==x){
			throw new AssertionError("last element is x");
		}
		else {

		
		for(int i=0;i<elementsOfArray.length;i++) {
			if(elementsOfArray[i]==x) {
				for(int j=flag;j<elementsOfArray.length;j++) {
					//if element is y and it is not placed at immediate right to x then we will swap it with immediate right of x
					if(elementsOfArray[j]==y && j!=i+1) {
						//Swapping 
						int temp=elementsOfArray[i+1];
						elementsOfArray[i+1]=y;
						elementsOfArray[j]= temp;
						//setting flag to current position so that we can start from in second pass
						flag=j;
					}
					else {
						continue;
					}
				}
			}
			else {
				continue;
			}
		}
		}
		
		return elementsOfArray;
	}

	/**
	 * find out the index of Array from where we need to split such both
	 * splitted array sum is equal
	 * 
	 * @param array
	 *            of positive integers
	 * 
	 * @throws assertion
	 *             error if array is empty
	 * 
	 * @return index of array from where we need to split
	 * 
	 */

	protected int splitArray() {
		if (arrayLength == 0) {
			throw new AssertionError("Array is Empty");
		} else {

			int sumStart = elementsOfArray[0];
			int sumEnd = elementsOfArray[arrayLength - 1];
			int index = 0, startAndEndDifference = 1;

			for (int i = 1, j = arrayLength - 2; i <= j;) {

				index = i;
				if (sumStart < sumEnd) {

					sumStart = sumStart + elementsOfArray[i];
					++i;
					startAndEndDifference = 1;
				} else if (sumEnd < sumStart) {
					sumEnd = sumEnd + elementsOfArray[j];
					--j;
					startAndEndDifference = 1;
				} else {

					sumStart = sumStart + elementsOfArray[i];
					++i;
					sumEnd = sumEnd + elementsOfArray[j];
					--j;
					startAndEndDifference = 0;
				}

			}

			if (sumStart == sumEnd && startAndEndDifference == 1) {
				return (index + 1);
			} else {
				return -1;

			}
		}
	}

}
