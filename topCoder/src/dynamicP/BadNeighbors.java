package dynamicP;

public class BadNeighbors {
	
	public int maxDonations(int[] donations) {
		int len = donations.length;
		int[] dp = new int[len];
		int res = 0;
		//ù��° �ֹ��� ���� ���� ������ �ֹ��� ���� �ȳ���.
		//ù��° �ֹ��� ���� �� ���� ������ �ֹ��� ���� ����.
		//�ΰ��� �ݺ����� ���� �޸�ȭ ��͹���� ����Ѵ�.
		
		for(int i = 0; i < len-1; i++) {
			//dp�� �κ����� �����ϴ� �迭
			dp[i] = donations[i];
			if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]); //���� ������ �հ� ���� �ֹ��� ������ ���ؼ� �ִ밪
			//�Ʒ� �ڵ带 ���� ���� �ֹΰ� ���� �ֹ��߿� ���� �� ���� ���� �´��� �񱳰� ����
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
		
		//�޸�ȭ ����� �ٽ��� ���갪�� �����ϴ� �����ε�.
		//�񱳴���� ��� ���� ������ ��� �����ٰ�����.
	}
}
