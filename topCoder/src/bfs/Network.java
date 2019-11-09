package bfs;
import java.util.*;
public class Network {
	public int solution(int n, int[][] computers) {
        int answer = 0, com = 0;
        boolean[] visited = new boolean[n];        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            q.offer(i);
            answer++;            
            while(!q.isEmpty()){
                com = q.poll();                
                visited[com] = true;
                for(int j = 0; j < n; j++){
                    if(computers[com][j] == 1 && !visited[j]){
                        q.offer(j);
                    }
                }               
            }
        }                    
        return answer;
    }
}
