package com.metacube.training.question1;

import java.util.Stack;

public class PostfixEvaluation {

	private String expression;
	private Stack<Integer> values;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Stack<Integer> getValues() {
		return values;
	}

	public void setValues(Stack<Integer> values) {
		this.values = values;
	}

	public PostfixEvaluation(String expression) {
		this.expression = expression;
		values=new Stack<Integer>();
	}

	public PostfixEvaluation() {

	}

	public int evaluateExpression()  {

		Character charAtIndex;
		int value1, value2;
		
		if(expression=="") {
			
		throw new AssertionError("Invalid expression");
			
		}
		for (int i = 0; i < expression.length(); ++i) {

			charAtIndex = expression.charAt(i);
			if(charAtIndex.equals(' ')) {
				continue;
			}
			if (Character.isDigit(charAtIndex)) {
				values.push(charAtIndex - '0');
			} else {
				switch (charAtIndex) {

				case '+':
					value1 = values.pop();
					value2 = values.pop();
					values.push(value2 + value1);
					break;

				case '-':
					value1 = values.pop();
					value2 = values.pop();
					values.push(value2 - value1);
					break;
				case '*':
					value1 = values.pop();
					value2 = values.pop();
					values.push(value2 * value1);
					break;
				case '/':
					value1 = values.pop();
					value2 = values.pop();
					if(value1==0) {
						throw new ArithmeticException("divide by zero exception caught");
					}
					values.push(value2 / value1);
					break;

				case '%':
					value1 = values.pop();
					value2 = values.pop();
					values.push(value2 % value1);
					break;
				default:throw new AssertionError("Invalid operator");
				}
			}

		}

		if(values.isEmpty()) {
			return 0;
		}
		return values.pop();

	}

}
