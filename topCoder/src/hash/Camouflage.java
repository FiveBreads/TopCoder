package hash;

import java.util.*;
public class Camouflage {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();                
        for(int i = 0; i < clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) {
        		int t = map.get(clothes[i][1]) + 1;
        		map.replace(clothes[i][1], t);
        	}else {
        		map.put(clothes[i][1], 1);
        	}
        }
        
        for(String str : map.keySet()){
            answer *= (map.get(str) + 1);
        }        
        return answer - 1;
    }
}
