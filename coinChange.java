package edu.princeton.cs.algs4;

// Given coins of different denominations and a total amount of money, 
// find the fewest number of coins that make up the amount.
public class coinChange {
	public static void main(String[] args){
		int[] coins = {1,2,5};
		int target = 8;
		int min = getMinCoin(coins, target);
		System.out.print(min);
	}
	public static int getMinCoin(int[] denom, int amount){
		int[] counts = new int[amount+1];
		int coins = 0;
		counts[0] = 0; // counts[K] denotes minimum amount of coins needed for amount K
		for(int i = 1; i <= amount; i++){
			coins = Integer.MAX_VALUE;
			for(int j = 0; j < denom.length; j++){
				if(denom[j] <= i){
					coins = Math.min(coins, counts[i - denom[j]]); //min{counts[K - d1]...counts[K-dn]}
				}
			}
			if(coins < Integer.MAX_VALUE)
				counts[i] = coins + 1;
			else
				counts[i] = Integer.MAX_VALUE;
		}
		coins = counts[amount];
		return coins;
	}
}
