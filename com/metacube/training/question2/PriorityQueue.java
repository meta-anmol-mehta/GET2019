package com.metacube.training.question2;

/**
 * Interface of Priority Queue consisting declarations of methods that has to be
 * implemented
 * 
 * @author admin
 *
 */
public interface PriorityQueue {

	/**
	 * Method to insert values to the queue
	 * 
	 * @param value
	 *            to be added to the queue
	 * @return true if value is added successfully else false
	 * @throws AssertionError
	 *             if size of the queue entered is negative or zero
	 *             if queue is empty or full
	 */
	public boolean enqueue(Job value) ;

	/**
	 * Method to remove a value from the queue
	 * 
	 * @return the Job object
	 * @throws AssertionError
	 *             if size of the queue entered is negative or zero
	 *             if queue is empty or full
	 */
	public Job dequeue();

	/**
	 * Method to find if the queue is empty or not
	 * 
	 * @return true if queue is empty else false
	 * @throws AssertionError
	 *             if size of the queue entered is negative or zero
	 */
	public boolean isEmpty() ;

	/**
	 * Method to find if a queue is full or not
	 * 
	 * @return true if queue is full else false
	 * @throws AssertionError
	 *             if size of the queue entered is negative or zero
	 */
	public boolean isFull() ;
}
