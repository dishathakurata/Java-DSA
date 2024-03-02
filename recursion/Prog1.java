package recursion;

/*
 * 1. Write a recursive function to calculate the gcd of two numbers.
 */

public class Prog1 {
	
	static int gcd(int a, int b) {
		
		if(b == 0) {
            return a;
        }
		
		else {
            return gcd(b, a % b);
        }
	}

	public static void main(String[] args) {
		int m = 12;
		int n = 8;
		
		System.out.println("Greatest Common Factor of " + m + " and " + n + "= " + gcd(m, n));
	}
}
