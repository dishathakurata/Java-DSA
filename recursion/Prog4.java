package recursion;

/*
 * 4. Write a recursive function to calculate the sum of all digits of a number entered by the user.
 */

public class Prog4 {
	
	static int sum(int n) {
		
		if(n < 10) {
            return n;
        }
        
        return n % 10 + sum(n / 10);
	}

	public static void main(String[] args) {
		int m = 456;
		
		System.out.println("Sum of digits of " + m + "= " + sum(m));
	}
}
