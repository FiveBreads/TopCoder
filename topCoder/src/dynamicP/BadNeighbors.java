package dynamicP;

public class BadNeighbors {
	
	public int maxDonations(int[] donations) {
		int len = donations.length;
		int[] dp = new int[len];
		int res = 0;
		//첫번째 주민이 돈을 내면 마지막 주민은 돈을 안내고.
		//첫번째 주민이 돈을 안 내면 마지막 주민은 돈을 낸다.
		//두개의 반복문을 통해 메모화 재귀방법을 사용한다.
		
		for(int i = 0; i < len-1; i++) {
			//dp는 부분합을 저장하는 배열
			dp[i] = donations[i];
			if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]); //그전 까지의 합과 현재 주민이 낼돈을 비교해서 최대값
			//아래 코드를 통해 현재 주민과 이전 주민중에 누가 더 돈을 많이 냈는지 비교가 가능
			if(i > 1) dp[i] = Math.max(dp[i], dp[i-2] + donations[i]); 
			res = Math.max(res, dp[i]);
		}
		
		for(int i = 0; i < len-1; i++) {
			dp[i] = donations[i+1];
			if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]);
			if(i > 1) dp[i] = Math.max(dp[i], dp[i-2] + donations[i+1]);
			res = Math.max(res, dp[i]);
		}
		
		return res;
		
		//메모화 재귀의 핵심은 연산값을 저장하는 생각인듯.
		//비교대상을 어떻게 가를 것인지 어떻게 더해줄건지도.
	}
}
