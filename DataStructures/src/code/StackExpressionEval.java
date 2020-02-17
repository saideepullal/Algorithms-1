package code;

import java.util.Scanner;
import java.util.Stack;

public class StackExpressionEval {

	public static void main(String[] args) {
		Stack<String>ops = new Stack<String>();
		Stack<Double>values =  new Stack<Double>();
		Scanner sc =  new Scanner(System.in);
		String input = null;
		
		do {

			input = sc.nextLine();

			// check if string is a number
			try {
				Double number = Double.parseDouble(input);
				if (number != null) {
					values.push(number);
				}
			} catch (NumberFormatException e) {
				// not a number
				if (input.equals("(")) {

				} else if (input.equals("+")) {
					ops.push(input);
				} else if (input.equals("-")) {
					ops.push(input);
				} else if (input.equals("*")) {
					ops.push(input);
				} else if (input.equals("/")) {
					ops.push(input);
				} else if (input.equals(")")) {
					String op = ops.pop();
					Double value = values.pop();

					if (op.equals("+")) {
						value = values.pop() + value;
					}

					else if (op.equals("-")) {
						value = values.pop() - value;
					}

					else if (op.equals("*")) {
						value = values.pop() * value;
					}

					else if (op.equals("/")) {
						value = values.pop() / value;
					}
					values.push(value);
				}

			}

		}while(!input.equals("q"));
		
		System.out.print(values.pop());
				
	}

}
