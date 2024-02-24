package stack;

/*
 * 3. Write a method in a separate class to evaluate a postfix expression (Consider more than single
digit number as a input).
 */

public class Prog3 {
	
	public static int postfixExp(String s) throws StackOverflowException, StackUnderflowException {
		Stack<Integer> obj = new Stack<>(s.length(), "Postfix Expression Stack");
		
		String[] op = s.split("\\s");
		
		for(String st: op) {
			if(st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/")) {
				int a = obj.pop();
				int b = obj.pop();
				
				switch(st) {
				case "+":
					obj.push(a+b);
					break;
				
				case "-":
					obj.push(b-a);
					break;
				
				case "*":
					obj.push(a*b);
					break;
				
				case "/":
					obj.push(b/a);
					break;
				
				default: break;
				}
			}
			
			else if(st.equals("(") || st.equals(")")) {
				continue;
			}
				
			else {
				int n = Integer.parseInt(st);
				obj.push(n);
			}
		}
		
		return obj.pop();
	}

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		System.out.println("Postfix evealuation= " + postfixExp("( 43 36 * 29 - )"));
	}
}
