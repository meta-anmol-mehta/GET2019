package com.metacube.training.question4;

public class StudentAllocationList {
	
	private String name;
	private String allocatedProgram;
	
	public StudentAllocationList(String name, String program) {
		this.name = name;
		this.allocatedProgram = program;
	}

	public String getName() {
		return name;
	}

	public String getAllocatedProgram() {
		return allocatedProgram;
	}

}
