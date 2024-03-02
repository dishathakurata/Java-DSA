package recursion;

/*
 * 5. Write a recursive function to find the sum of the following series.

(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
(b) S= 1^2 - 3^2 + 5^2 - 7^2 + . . . . . . + N (Input N).
(c) S= x^3 - x^3/3 + x^3/9 - x^3/27 + x^3/81 - x^3/243 ....(Input X,N).
 */
public class Prog5 {
	
	//(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
	static int sumA(int na) {
		
		if(na <= 0) {
            return 0;
        }
		
		else {
            return na + sumA(na - 2);
        }
	}
	
	//(b) S= 1^2 - 3^2 + 5^2 - 7^2 + . . . . . . + N (Input N).
	static int sumB(int nb) {
		
		if(nb <= 0) {
            return 0;
        }
		
		else {
            if(nb % 2 == 0) {
                return -nb * nb + sumB(nb - 1);
            }
            else {
                return nb * nb + sumB(nb - 1);
            }
        }
	}
	
	//(c) S= x^3 - x^3/3 + x^3/9 - x^3/27 + x^3/81 - x^3/243 ....(Input X,N).
	static double sumC(int x, int nc) {
		
		if(nc <= 0) {
            return 0;
        }
		
		else {
            double term = Math.pow(x, 3) / Math.pow(3, nc - 1);
            return term + sumC(x, nc - 1);
        }
	}

	public static void main(String[] args) {
		int m = 10;
		int n = 9;
		int y = 2;
		
		System.out.println("Sum of series (a)= " + sumA(m));
		System.out.println("Sum of series (b)= " + sumB(n));
		System.out.println("Sum of series (c)= " + sumC(y, n));

	}

}
