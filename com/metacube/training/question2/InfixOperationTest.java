package com.metacube.training.question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfixOperationTest {

	@Test
	public void testWithoutParanthesis()  {
		InfixOperation postfix = new InfixOperation("a + b");
		String result=postfix.findPostfixExpression();
		assertEquals("ab+",result);
	}
	
	
	@Test
	public void testWithParanthesis()  {
		InfixOperation postfix = new InfixOperation("( a + b ) * ( c + d )");
		String exp = postfix.findPostfixExpression();
		assertEquals(exp, "ab+cd+*");
	}
	
}
