package stack;

/*
 * 4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single
digit number as a input)
 */

public class Prog4 {
	
	public static int prefixExp(String s) throws StackOverflowException, StackUnderflowException {
		Stack<Integer> obj = new Stack<>(s.length(), "Prefix Expression Stack");
		
		String[] op = s.split("\\s");
		String[] temp = new String[op.length];
		int x = op.length;
		
		for(int i = 0; i < op.length; i++) {
			temp[x - 1] = op[i];
			x--;
		}
		
		for(String st: temp) {
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
		System.out.println("Prefix evealuation= " + prefixExp("( + 39 * 24 56 )"));
	}
}
