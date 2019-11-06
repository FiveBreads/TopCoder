package dynamicP;

import java.util.Arrays;

public class BackPack {
	/*
	int[] ws = {3,4,1,2,3}; //무게
	int[] ps = {2,3,2,3,6}; //가치
	int maxw = 10;			//무게 최대값
	int ret = 0;			//가치의 최대값
	
	int[][] dp = new int[6][11];
	
	int weightPrice(int idx, int w) {		
		if(w > maxw) return -1;
		if(idx >= ws.length) return 0;
		if(dp[idx][w] >= 0) return dp[idx][w];
		return dp[idx][w] = Math.max(weightPrice(idx + 1, w), weightPrice(idx + 1, w + ws[idx]) + ps[idx]);		
	}
	*/
	public static void main(String[] args) {
		int w = 0;
		int p = 0;
		
		int maxw = 10;
		int ret = 0;
		
		int[] ws = {3,4,1,2,3};
		int[] ps = {2,3,2,3,6};
		
		int[][] dp = new int[6][11];
		Arrays.fill(dp, -1);
		dp[0][0] = 0;
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				if(j + ws[i] <= maxw) {
					
					dp[i + 1][j + ws[i]] = Math.max(dp[i + 1][j + ws[i]], dp[i][j] + ps[i]);
					ret = Math.max(dp[i + 1][j + ws[i]], ret);
					
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
					dp[i+1][j + ws[i+1]] = Math.max(dp[i+1][j + ws[i+1]], dp[i][j] + ps[i+1]);
				}
			}
		}
		
	}
}


