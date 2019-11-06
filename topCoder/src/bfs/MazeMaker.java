
package bfs;
import java.util.*;
public class MazeMaker {
	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		int width = maze[0].length();
		int height = maze.length;
		int max = 0;
		
		int[][] board = new int[height][width];		
		Arrays.fill(board, -1);
		
		board[startRow][startCol] = 0;
		
		Queue<Integer> queX = new LinkedList<>();
		Queue<Integer> queY = new LinkedList<>();
		
		queX.add(startRow);
		queY.add(startCol);
		
		while(!queX.isEmpty()) {
			int moveX = queX.poll();
			int moveY = queY.poll();
			for(int i = 0; i < moveRow.length; i++) {
				int x = moveX + moveRow[i];
				int y = moveY + moveCol[i];
				if(x >= 0 && x < width 
						&& y >= 0 && y < height
						&& board[y][x] == -1
						&& maze[y].charAt(x) == '.') {
					board[y][x] = board[moveY][moveX] + 1;
					
					queX.add(x);
					queY.add(y);
				}
			}
			
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if(maze[i].charAt(j) == '.' && board[i][j] == -1) {
						return -1;					
					}
					max = Math.max(max,  board[i][j]);
				}
			}
			
		}	
		return max;
	}
}
