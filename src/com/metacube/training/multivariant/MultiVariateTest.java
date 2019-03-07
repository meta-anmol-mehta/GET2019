package com.metacube.training.multivariant;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiVariateTest {

	VariableList variable1 = new VariableList('x', 2);
	VariableList variable2 = new VariableList('y', 0);
	VariableList variable3 = new VariableList('z', 1);
	
	List<VariableList> variableList1 = new ArrayList<VariableList>(){{add(variable1); add(variable2);}};
	List<VariableList> variableList2 = new ArrayList<VariableList>(){{add(variable1); add(variable2); add(variable3);}};
	
	Term term1 = new Term(4.00, variableList1);
	Term term2 = new Term(3.00, variableList2);
	
	List<Term> termList = new ArrayList<Term>(){{add(term1); add(term2);}};
	
	@Test
	public void Visualisationtest() {
		MultiVariate multiVariateObject = new MultiVariate(termList);
		assertEquals("4.0 * x^2 * y^0 + 3.0 * x^2 * y^0 * z^1", multiVariateObject.visualisedMultivariatePolynomial());
	}
	
}
