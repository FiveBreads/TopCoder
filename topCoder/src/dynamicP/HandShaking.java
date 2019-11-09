package dynamicP;

import java.util.Arrays;
import java.util.Scanner;

public class HandShaking {
	
	public static long countPerfect(int n) {
	 	int caseNum = n/2;
	 	long[] dp = new long[caseNum + 1]; 	
	 	Arrays.fill(dp, 0);	 	
	 	dp[0] = 1;	 	
	 	for(int i = 1; i <= caseNum; i++) {
	 		for(int j = 0; j < i; j++) {
	 			dp[i] += (dp[j] * dp[i - j - 1]);
	 		}
	 	}	  	
	 	return dp[caseNum];
	}
	
	public static long countPerfectOfficial(int n) {
		int caseNum = n/2;
	 	long[] dp = new long[caseNum + 1]; 	
	 		 	
	 	dp[0] = 1;
	 	
	 	for(int i = 1; i <= caseNum; i++) {
	 		dp[i] = 0;
	 		for(int j = 0; j < i; j++) {
	 			dp[i] += (dp[j] * dp[i - j - 1]);
	 		}
	 	}	  	
	 	return dp[caseNum];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("입력값 : " + a);
		System.out.println("내 풀이 답 : " + countPerfect(a));
		System.out.println("책 풀이 답 : " + countPerfectOfficial(a));
	}
}
