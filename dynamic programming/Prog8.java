package greedyANDdp;

/*
 * 8. Given a set of non-negative integers, and a value sum, Write a program to determine if there is a
subset of the given set with sum equal to given sum. Input: set [] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True [ There is a subset (4, 5) with sum 9]
 */

public class Prog8 {
	
	static boolean isSubsetSum(int set[], int n, int sum) {
		if(n == 0)
			return false;
		
		boolean[][] subset = new boolean[sum + 1][n + 1];
		
		for(int i = 0; i <= n; i++)
			subset[0][i] = true;
		
		for(int i = 1; i <= sum; i++)
			subset[i][0] = false;
		
		for(int i = 1; i <= sum; i++) {
            for(int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                
                if(i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }
		
		return subset[sum][n];
	}

	public static void main(String[] args) {
		int[] set = {3, 34, 4, 12, 5, 2};
		int n = set.length;
		int sum = 9;
		
		System.out.println(isSubsetSum(set, n, sum));
	}
}