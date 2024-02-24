package stack;

/*
 * 6. Write a method in a separate class to convert an infix expression to its corresponding prefix
expression.
 */

public class Prog6 {
	
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
	
	public static String infixToPrefixExp(String s) throws StackOverflowException, StackUnderflowException {
		Stack<Character> obj = new Stack<>(s.length(), "Infix to Prefix Expression Stack");
		
		String revS = "";
		String out = "";
		String res = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == ')')
				revS += '(';
			
			else if(s.charAt(i) == '(')
				revS += ')';
			
			else {
				revS += s.charAt(i);
			}
		}
		
		for(int i = 0; i < revS.length(); i++) {
			char ch = revS.charAt(i);
			
			if(ch == '(')
				obj.push(ch);
			
			else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				out += ch;
			
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='^') {
				if(obj.getTop() == -1 || obj.peek() == '(')
					obj.push(ch);
				
				else {
					if((prec(ch) <= prec(obj.peek()))) {
						while((prec(ch) <= prec(obj.peek()))) {
							out += obj.pop();
						}
						obj.push(ch);
					}
					
					else
						obj.push(ch);
				}
				
			}
			
			else if(ch == ')') {
				while(obj.peek() != '(') {
					out += obj.pop();
				}
			}
			
		}
		
		if(!obj.isEmpty() && obj.peek() != '(')
			out += obj.pop();
		
		for(int i = out.length() - 1; i >= 0; i--) {
			res += out.charAt(i);
		}
		
		return res;
	}

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		System.out.println("Infix to Prefix= " + infixToPrefixExp("(A*B+C/D)"));    
	}
}
