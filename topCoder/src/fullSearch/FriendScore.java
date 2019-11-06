package fullSearch;

public class FriendScore {

	public int highestScore(String[] friends) {
		int ans = 0;
		int n = friends.length;
		for(int i = 0; i < n; i++) {
			int temp = 0;
			
			for(int j = 0; j < n; i++) { //i狼 流立模备
				if(i == j) continue;
				if(friends[i].charAt(j) == 'Y') {
					temp++;					
				}else {
					for(int k = 0; k < n; k++) {
						if(friends[i].charAt(k) == 'Y' && friends[j].charAt(k) == 'Y') {
							temp++;
							break;
						}
					}
				}
			}			
			ans = Math.max(temp, ans);
		}		
		return ans;
	}
}
