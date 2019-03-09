package com.metacube.training.question2;

import java.util.Stack;

public class InfixOperation {

	
	String infixExp;
	Stack<String> stack = new Stack<String>();

	public InfixOperation(String infixExp) {
		this.infixExp = infixExp;
	}

	/**
	 * Method to find the postfix expression
	 * 
	 * @return postfix expression
	 * @throws StackException
	 */
	String findPostfixExpression()  {
		StringBuilder postfix = new StringBuilder();
		String infix[] = infixExp.split("\\s+");

		for (int i = 0; i < infix.length; i++) {
			
			System.out.println(infix[i]);

			if (infix[i].matches("[a-z]*[A-Z]*[0-9]*")) {
				postfix.append(infix[i]);
			}
			if ("(".equals(infix[i])) {
				stack.push(infix[i]);
			} else {
				if (")".equals(infix[i]) && !(stack.isEmpty())) {
					while (!(stack.isEmpty()) && !("(".equals(stack.peek()))) {
						postfix.append(stack.pop());
					}
					if (!(stack.isEmpty()) && !("(".equals(stack.peek()))) {
						throw new AssertionError("invalid expression");
					}
					if (!(stack.isEmpty()) && "(".equals(stack.peek())) {
						stack.pop();
					}

				} else {
					if (isOperator(infix[i])) {
						if (stack.isEmpty()) {
							stack.push(infix[i]);
						} else {
							if (((getPrecedence(infix[i])) > (getPrecedence(stack
									.peek())))) {
								stack.push(infix[i]);
							} else {
								while (!(stack.isEmpty())
										&& (getPrecedence(infix[i]) <= getPrecedence(stack
												.peek()))
										&& !("(".equals(stack.peek()))) {
									postfix.append(stack.pop());
								}
								stack.push(infix[i]);
							}
						}

					}

				}
			}
		}
		while (!(stack.isEmpty())) {
			postfix.append(stack.pop());
		}
		return postfix.toString();

	}
	/**
	 * Helper function to check if a current token is an operator or not
	 * 
	 * @param checkToken
	 *            , current token to check
	 * @return true if a token is operator else false
	 */
	private boolean isOperator(String checkToken) {
		switch (checkToken) {
		case "!":
		case "*":
		case "/":
		case "+":
		case "-":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
		case "(":
		case ")":
			return true;
		default:
			return false;
		}
	}

	/**
	 * Helper function to calculate the precedence of a operator
	 * 
	 * @param operator
	 *            , input operator
	 * @return precendence of the operators
	 */
	private int getPrecedence(String operator) {
		switch (operator) {
		case "!":
		case "(":
		case ")":
			return 1;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 5;
		case "&&":
			return 6;
		case "||":
			return 7;
		}
		return -1;
	}
	
}
