package greedyANDdp;

/*
 * 7. Write a program to find out the minimum no of coins to make change of given amount
For example, for N = 10 and S = {1,5,6,9}, there are two solutions: {5,5},{1,9} So output should
be 2. [Infinite Supply of coins]
 */

public class Prog7 {
	
	static int coinsCount(int[] coins, int n, int amount) {
		if(n == 0)
			return 0;
		
		int[][] dp = new int[n][amount + 1];
		
		for(int i = 0; i < n; i++)
			dp[i][0] = 0;
		
		for(int i = 1; i <= amount; i++)
			dp[0][i] = i;
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= amount; j++) {
				if(coins[i] <= j)
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
				
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		
		for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++)
                System.out.print(dp[i][j] + "\t");
            System.out.println(); 
        }
		
		return dp[n - 1][amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 5, 6, 9};
		int n = coins.length;
		int amount = 10;
		
		System.out.println("Minimum number of coins required = " + coinsCount(coins, n, amount));
	}
}