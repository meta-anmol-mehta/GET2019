package com.metacube.training.multivariant;

/**
 * This class defines all present variables in a term of multivariate
 * polynomial.
 * 
 */
public  class VariableList {
	private char variable;
	private int power;

	public VariableList(char variable, int power) {
		this.variable = variable;
		this.power = power;
	}

	public char getVariable() {
		return variable;
	}

	public void setVariable(char variable) {
		this.variable = variable;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
	
}