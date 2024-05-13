package greedyANDdp;

/*
 * 6. Write a program to find out the total number of ways to make change of given amount.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
So output should be 4. [Infinite Supply of coins]
 */

public class Prog6 {
	
	static int coinsChange(int[] coins, int amount) {
		if(amount == 0 || coins.length == 0)
			return 0;
		
		int[][] dp = new int[coins.length][amount + 1];
		
		for(int i = 0; i < coins.length; i++)
			dp[i][0] = 1;
		
		for(int i = 1; i <= amount; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				if(coins[i] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                else
                    dp[i][j] = dp[i - 1][j];

			}
		}
		
		for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++)
                System.out.print(dp[i][j] + "\t");
            System.out.println(); 
        }

		return dp[coins.length - 1][amount];
		
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int amount = 4;
		
		System.out.println("Coins change required = " + coinsChange(coins, amount));
	}
}