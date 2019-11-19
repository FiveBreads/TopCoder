package greedy;

public class ColorfulBoxesAndBalls {
	public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		int n = Math.min(numBlue, numRed);
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			int res = (numRed-i)*onlyRed + (numBlue-i)*onlyBlue + (i*2*bothColors);
			ans = Math.max(res, ans);
		}
		return ans;
	}
}
