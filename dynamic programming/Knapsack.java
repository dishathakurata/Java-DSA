package greedyANDdp;

import java.util.*;

/*
 * 5. Write a program to implement 0/1 knapsack.
 */

class Knapsack {
    static int knapsack(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W + 1];

        for(int i = wt[0]; i <= W; i++)
            dp[0][i] = val[0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= W; j++) {
                if(j < wt[i - 1])
                	dp[i][j] = dp[i - 1][j];
                
                else {
                	dp[i][j] = Math.max(dp[i - 1][j],  val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= W; j++)
                System.out.print(dp[i][j] + "\t");
            System.out.println(); 
        }
        
        return dp[n - 1][W];
    }

    public static void main(String args[]) {
        int wt[] = {3, 4, 5, 6};
        int val[] = {2, 3, 4, 1};
        int W = 8;
        int n = wt.length;

        System.out.println("Maximum value of items the thief can steal = " + knapsack(wt, val, n, W));
    }
}