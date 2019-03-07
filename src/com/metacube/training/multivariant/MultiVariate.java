package com.metacube.training.multivariant;

import java.util.List;

/**
 * 
 * This class is used to visualize a multivariate polynomial using nested linked
 * list.
 * 
 * 
 */
public class MultiVariate {

	private List<Term> multivariate;

	public MultiVariate(List<Term> multivariate) {
		this.multivariate = multivariate;
	}

	/**
	 * 
	 * @return multivariate polynomial with all the terms in it.
	 */
	public String visualisedMultivariatePolynomial() {
		String polynomial = "";
		for (Term term : multivariate) {
			polynomial += term.coefficient;
				polynomial += " * " + term.variable.getVariable() + "^"
						+ term.variable.getPower();
			if (term != multivariate.get(multivariate.size() - 1)) {
				polynomial += " + ";
			}
		}
		return polynomial;
	}

}
