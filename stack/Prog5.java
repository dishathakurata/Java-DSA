package stack;

/*
 * 5. Write a method in a separate class to convert an infix expression to its corresponding postfix
expression.
 */

public class Prog5 {
	
	static int prec(char c) {
        if(c == '^')
        	return 3;
        else if(c == '/' || c == '*')
            return 2;
        else if(c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    static char associativity(char c) {
        if(c == '^')
            return 'R';
        return 'L';
    }
	
	public static String infixToPostfixExp(String s) throws StackOverflowException, StackUnderflowException {
		Stack<Character> obj = new Stack<>(s.length(), "Infix to Prefix Expression Stack");
		
		String out = "";
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch == '(')
				obj.push(ch);
			
			else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				out += ch;
			
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='^') {
				if(obj.getTop() == -1 || obj.peek() == '(')
					obj.push(ch);
				
				else {
					if((prec(ch) <= prec(obj.peek()))) {
						while((prec(ch) <= prec(obj.peek())) || obj.peek() != '(') {
							out += obj.pop();
						}
						obj.push(ch);
					}
					
					else
						obj.push(ch);
				}
				
			}
			
			else if(ch == ')') {
				while(obj.peek() != '(')
					out += obj.pop();
			}
			
		}
		
		while(!obj.isEmpty() && obj.peek() != '(')
			out += obj.pop();
		
		return out;
	}

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		System.out.println("Infix to Postfix= " + infixToPostfixExp("(a+b*c-d)+f-g"));

	}

}
