package bfs;
import java.util.*;
public class CrazyBot {
	
	int[] vx = {1, -1, 0, 0};
	int[] vy = {0, 0, 1, -1};
	
	double[] prob = new double[4];
	
	public double getProbability(int n, int east, int west, int south, int north) {
		prob[0] = east/100.0;
		prob[1] = west/100.0;
		prob[2] = south/100.0;
		prob[3] = north/100.0;	
		
		return bfs(n);
	}
	
	double bfs(int n) {
		if(n == 0) return 1;
		Queue<Double> q = new LinkedList();
		for(int i = 0; i < 4; i++) {
			if(prob[i] != 0) {
				q.add(prob[i]);
			}			
		}
		double ans = 0;
		while(!q.isEmpty()) {			
			ans += q.poll();
			ans *= bfs(n - 1);			
		}		
		return ans;
	}
}
