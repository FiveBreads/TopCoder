package dfs;
import java.util.*;
public class CrazyBot {
	boolean[][] grid = new boolean[100][100];
	int vx[] = {1, -1, 0, 0};
	int vy[] = {0, 0, 1, -1};
	
	double[] prob = new double[4];
	
	public double getProbability(int n, int east, int west, int south, int north) {
		//로봇은 n번 움직인다. 뱡향의 합은 100이다. n을 깊이라고 할 수 있다.
		prob[0] = east/100.0;
		prob[1] = west/100.0;
		prob[2] = south/100.0;
		prob[3] = north/100.0;
		
		return dfs(50, 50, n);		
	}
	
	double dfs(int x, int y, int n) {
		if (grid[x][y]) return 0; // 가지치기 조건
		if (n == 0)		return 1; // 종료 조건
		
		grid[x][y] = true;
		double ret = 0;
		for (int i = 0; i < 4; i++) {
			ret += dfs(x + vx[i], y + vy[i], n-1) * prob[i];
		}
		grid[x][y] = false;
		return ret;
	}
}
