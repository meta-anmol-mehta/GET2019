package com.metacube.training.question4;

public class Program {

	private String name;
	private int capacity;
	private int remaining;

	public Program(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.remaining = capacity;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getRemainig() {
		return remaining;
	}

	public void setRemainig(int remaining) {
		this.remaining = remaining;
	}

}
