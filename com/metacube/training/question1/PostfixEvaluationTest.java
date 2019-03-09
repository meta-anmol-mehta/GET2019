package com.metacube.training.question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PostfixEvaluationTest {
	

	@Test
	public void testSingleValueDigit()   {
		PostfixEvaluation evaluate = new PostfixEvaluation("2 3 1 * + 9 -");
		double result = evaluate.evaluateExpression();
		assertEquals(-4, result,0);
	}
	
	
	
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero()   {
		PostfixEvaluation evaluate = new PostfixEvaluation("1 2 + 0 / 5 * 7 +");
		double result = evaluate.evaluateExpression();
	}
	
	@Test
	public void testInvalidOperator()   {
		PostfixEvaluation evaluate = new PostfixEvaluation("1 2 + 3 / 5 * 7 &");
		double result = evaluate.evaluateExpression();
		System.out.println(result);
	}
	
	@Test(expected=AssertionError.class)
	public void testInvalidExpression()   {
		PostfixEvaluation evaluate = new PostfixEvaluation("");
		double result = evaluate.evaluateExpression();
		
	}

}
