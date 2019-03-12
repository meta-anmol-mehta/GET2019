package com.metacube.training.question2;

/**
 * Class Job which stores value as well as priority of any job
 * 
 * @author Admin
 *
 */
public class Job {

	private int value;
	private int priority;

	public Job(int value, int priority) {

		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}

}
