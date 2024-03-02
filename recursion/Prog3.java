package recursion;

/*
 * 3. Write a recursive function to calculate the power of a two number(consider the degree as a
negative/positive integer).
 */

public class Prog3 {
	
	static int power(int base, int exp) {
		if(exp == 0) {
            return 1;
        }
		
        if(exp < 0) {
            return 1 / power(base, -exp);
        }
        
        return base * power(base, exp - 1);
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		int c = 0;
		int d = -3;
		
		System.out.println("Power of two numbers= " + power(a, b));
		System.out.println("Power of two numbers= " + power(a, c));
		System.out.println("Power of two numbers= " + power(a, d));
	}
}
