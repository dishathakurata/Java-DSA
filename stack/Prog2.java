package stack;

/*
 * 2. Write a method in a separate class to check an expression is valid or not.
 */

public class Prog2 {
	
	public static boolean checkExpression(String s) throws StackOverflowException, StackUnderflowException {
		Stack ob = new Stack(s.length(), "Expression Stack");
		
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '{' || c == '[') {
				ob.push(c);
			}
		}
		
		for(char c : s.toCharArray()) {
			if(c == ')' || c == '}' || c == ']') {
				ob.pop();
			}
		}
		
		if(ob.getTop() < 0)
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		System.out.println("Is the expression valid?");
		System.out.println(checkExpression("[a+b]+(c+d)"));
	}

}