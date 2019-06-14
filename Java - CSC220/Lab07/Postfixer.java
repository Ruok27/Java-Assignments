package lab07;

import java.util.Stack;

public class Postfixer {

	public static double InfixEvaluator(String line) {

		StringSplitter data = new StringSplitter(line);

		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack<Double>();

		// 1. Scan the input string (infix notation) from left to right. One
		// pass is sufficient, take one token
		// at a time.

		while (data.hasNext()) {

			String token = data.next();
			char next = token.charAt(0);
			// 2. if the token is:
			// 2.1. number: push it onto the operand stack.

			if (next >= '0' && next <= '9') {
				operands.push(Double.parseDouble(token));
			}

			// 2.2. a left parenthesis: push it onto the operator stack.

			else if (next == '(') {

				operators.push("(");

			}

			// 2.3. a right parenthesis:

			else if (next == ')') {

				// 2.3.1. while the thing on top of the operator stack is not a
				// left parenthesis
				// 2.3.1.1. pop an operator from the operator stack, pop two
				// operands from the
				// operand stack, apply the operator to the operands, in the
				// correct order, push
				// the result onto the operand stack
				// 2.3.2. pop the left parenthesis from the operator stack and
				// discard it
				while (!operators.peek().equals("(")) {

					String op = operators.pop();
					double b = operands.pop();
					double a = operands.pop();

					operands.push(evaluate(a, op, b));
				}

				operators.pop();

			}
			// 2.4. an operator (call it current operator):

			else {
				// 2.4.1. while the operator stack is not empty, and the top
				// thing on the operator stack
				// has the same or greater precedence as the current operator
				// 2.4.1.1. pop an operator from the operator stack, pop two
				// operands from the
				// operand stack, apply the operator to the operands, in the
				// correct order, push
				// the result onto the operand stack
				while (!operators.isEmpty() && precedence(operators.peek()) > precedence(token)) {

					String op = operators.pop();
					double b = operands.pop();
					double a = operands.pop();

					operands.push(evaluate(a, op, b));

				}
				// 2.4.2. push the current operator onto the operator stack

				operators.push(token);

			}

		}
		// 3. While the operator stack is not empty
		// 3.1. pop an operator from the operator stack, pop two operands from
		// the operand stack,
		// apply the operator to the operands, in the correct order, push the
		// result onto the
		// operand stack

		while (!operators.isEmpty()) {

			String op = operators.pop();
			double b = operands.pop();
			double a = operands.pop();

			operands.push(evaluate(a, op, b));

		}
		// 4. At this point the operator stack MUST be empty, and the operand
		// stack MUST have a single
		// value, which is the final result.

		// 5. pop that value and return it.

		return operands.pop();
	}

	public static String PostfixConvertor(String line) {
		


		StringSplitter data = new StringSplitter(line);

		Stack<String> operators = new Stack<String>();
		Stack<String> operands = new Stack<String>();
		
		String postfix = "";
		

		while (data.hasNext()) {

			String token = data.next();
			char next = token.charAt(0);
			

			if (next >= '0' && next <= '9') {
				operands.push(token);
			}


			else if (next == '(') {

				operators.push("(");

			}

			
			else if (next == ')') {

				
				while (!operators.peek().equals("(")) {

					
					String op = operators.pop();
					String b = operands.pop();
					String a = operands.pop();

					postfix += a + "" + b + "" + op;
				}

				operators.pop();

			}
			
			else {
				
				while (!operators.isEmpty() && precedence(operators.peek()) > precedence(token)) {

					String op = operators.pop();
					String b = operands.pop();
					String a = operands.pop();

					postfix += a + "" + b + "" + op;
				}
				

				operators.push(token);

			}

		}
		
		while (!operators.isEmpty()) {

			String op = operators.pop();
			String b = operands.pop();
			String a = operands.pop();

			postfix += a + "" + b + "" + op;

		}
		
		System.out.println(postfix);
		return postfix;
	
		
	}

	// Helper methods

	private static double evaluate(double a, String op, double b) {

		char opt = op.charAt(0);

		switch (opt) {

		case '*':
			return a * b;

		case '+':
			return a + b;

		case '-':
			return a - b;

		case '/':
			return a / b;

		case '^':
			return Math.pow(a, b);

		default:

			throw new IllegalArgumentException("Operator " + opt + " not supproted");

		}

	}

	public static Boolean isOperator(String token) {
		char opt = token.charAt(0);

		switch (opt) {

		case '^':
		case '*':
		case '/':
		case '+':
		case '-':
		case '(':
		case ')':

			return true;

		default:

			throw new IllegalArgumentException("Operator " + opt + " not supproted");

		}
	}

	/*
	 * 
	 * public Double Operator2number(token){
	 * 
	 * number }
	 * 
	 */

	private static int precedence(String op) {
		char opt = op.charAt(0);

		switch (opt) {

		case '^':
			return 4;
		case '*':
		case '/':
			return 3;
		case '+':
		case '-':
			return 2;
		case '(':
		case ')':
			return 1;

		default:

			throw new IllegalArgumentException("Operator " + opt + " not supproted");

		}
	}

	public static void main(String[] args) {

		// test 1

		if (InfixEvaluator("10 + 2") != 12)
			System.err.println("test1 failed --> your answer should have been 12");

		if (InfixEvaluator("10 - 2") != 8)
			System.err.println("test1 failed --> your answer should have been 12");

		if (InfixEvaluator("100 * 2 + 12") != 212)
			System.err.println("test2 failed --> your answer should have been 212");

		if (InfixEvaluator("100 * ( 2 + 12 )") != 1400)
			System.err.println("test3 failed --> your answer should have been 1400");

		if (InfixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
			System.err.println("test4 failed --> your answer should have been 100");

		System.out.println("Testing Done!!!");

		// test 2

//		 if (!PostfixConvertor(new String("(4+5)")).equals("45+"))
//		 System.err.println("test1 failed --> should have been 45+");
		
//		 if (!PostfixConvertor(new String("((4+5)*6)")).equals("45+6*"))
//		 System.err.println("test2 failed --> should have been 45+6*");
		
		// if (!PostfixConvertor(new
		// String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		// System.err.println("test3 failed --> should have been 456*7/+8-");
		//
		// if (!PostfixConvertor(new
		// String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		// System.err.println("test4 failed --> should have been 4567-*+8/");
		//
		// if (!PostfixConvertor(new
		// String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		// System.err.println("test5 failed --> should have been
		// 987*654^/3*-2*+");
		//
		// System.out.println("Testing Done!!!");

	}

}
