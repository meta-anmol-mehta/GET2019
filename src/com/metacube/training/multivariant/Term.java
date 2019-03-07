package com.metacube.training.multivariant;

import java.util.List;

import com.metacube.training.multivariant.VariableList;

/**
 * This class defines a term of a multivariate polynomial.
 */
public  class Term {
	public double coefficient;
	public List<VariableList> variableList;

	public Term(double coefficient, List<VariableList> variableList) {
		this.coefficient = coefficient;
		this.variableList = variableList;
	}

}