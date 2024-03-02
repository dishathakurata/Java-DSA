package recursion;

/*
 * 2. Write a recursive function to print the first n Fibonacci numbers.
 */

public class Prog2 {
	
	static int fibonacci(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		int m = 9;
		
		System.out.print("Fibonacci series upto series " + m + ": ");
		for(int i = 0; i < m; i++) {
			System.out.print(fibonacci(i) + " ");
		}	
	}
}
