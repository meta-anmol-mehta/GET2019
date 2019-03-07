package com.metacube.training.nestedlist;

public interface NestedList {
	
	/**
	 * sumOfAllvalues will calculate the sum of all values present in nested
	 * list
	 * 
	 * @param nestedList
	 *            whose values sum is to be calculated
	 * @return sum of all values of nested list 
	 */
	public long sumOfAllValues() ;

	/**
	 * largestValue will find the largest value present in nested list
	 * 
	 * @param nestedList
	 *            in which largest value is to be searched
	 * @return largest value in nested list
	 */
	public long largestValue();

	/**
	 * searchValue will search the element in nested list
	 * 
	 * @param nestedList
	 *            in which value is to be searched
	 * @param element
	 * @return true if element found
	 */
	public boolean searchValue(int element);

}
