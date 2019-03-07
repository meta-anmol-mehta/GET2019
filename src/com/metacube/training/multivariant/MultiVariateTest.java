package com.metacube.training.multivariant;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiVariateTest {

	VariableList variable1 = new VariableList('x', 2);
	VariableList variable2 = new VariableList('y', 0);
	VariableList variable3 = new VariableList('z', 1);
	
	Term term1 = new Term(4.00, variable1);
	Term term2 = new Term(3.00, variable2);
	Term term3 = new Term(3.00, variable3);
	
	List<Term> termList = new ArrayList<Term>(){{add(term1); add(term2);add(term3);}};
	
	@Test
	public void Visualisationtest() {
		MultiVariate multiVariateObject = new MultiVariate(termList);
		assertEquals("4.0 * x^2 + 3.0 * y^0 + 3.0 * z^1", multiVariateObject.visualisedMultivariatePolynomial());
	}
	
}
