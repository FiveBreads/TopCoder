package dynamicP;

import java.util.Arrays;

//3���� �迭�� ����ϰ� �Ǹ� ���� ������ �ٰ� �ȴ�..
//������ 3���� �迭�� �Ⱦ����� �ϴϱ� �ڵ尡 �̷��� �������
//3�����迭 �ʹ� ��.��.

public class ChessMetric {
	int[] dx = {0, 1, 1, 1, 0, -1, -1, -1, 1, 2, 2, 1, -1, -2, -2, -1};
	int[] dy = {1, 1, 0, -1, -1, -1, 0, 1, 2, 1, -1, -2, -2, -1, 1, 2};
			
	long[][] mapA = new long[100][100];
	long[][] mapB = new long[100][100];
	
	boolean flag = true;
	
	public long howMany(int size, int[] start, int[] end, int numMoves) {
		long ans = 0;		
		int sx = start[0], sy = start[1], ex = end[0], ey = end[1];
		mapB[sy][sx] = 1;
		
		for(int i = 0; i < numMoves; i++) {
			if(flag) 
			{
				for(int x = 0; x < size; x++) {
					for(int y = 0; y < size; y++) {
						for(int j = 0; j < 16; j++) {
							int nx = x + dx[j];
							int ny = y + dy[j];
							
							if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
							
							mapA[ny][nx] += mapB[y][x];
						}
					}
				}
				flag = false;
				Arrays.fill(mapB, 0);
			}else 
			{
				for(int x = 0; x < size; x++) {
					for(int y = 0; y < size; y++) {
						for(int j = 0; j < 16; j++) {
							int nx = x + dx[j];
							int ny = y + dy[j];
							
							if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
							
							mapB[ny][nx] += mapA[y][x];
						}
					}
				}
				flag = true;
				Arrays.fill(mapA, 0);
			}
		}
		
		if(flag) {
			ans = mapB[ey][ex];
		}else {
			ans = mapA[ey][ex];
		}
		
		return ans;
	}
}
