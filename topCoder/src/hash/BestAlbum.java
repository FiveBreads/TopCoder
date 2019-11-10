package hash;
import java.util.*;
import java.util.Map.Entry;
public class BestAlbum {
	public int[] solution(String[] genres, int[] plays) {        
        HashMap<String, Integer> bestGenres = new HashMap<>(); 
        /*장르별 재생횟수 통합*/
        for(int i = 0; i < plays.length; i++) {
        	String key = genres[i];
        	int value = plays[i];        	
        	if(bestGenres.containsKey(key)) {
        		bestGenres.put(key, bestGenres.get(key) + value);
        	}else {
        		bestGenres.put(key, value);
        	}        	
        } 
        
        /*통합된 장르를 재생횟수로 내림차순 정렬*/
        List<Map.Entry<String, Integer>> sortedMap = new LinkedList<>(bestGenres.entrySet());
        Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int comparision = (o1.getValue() - o2.getValue()) * -1;
				return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
			}        	
        });      
                
        /*장르 내에서 최대값 두 개까지 뽑음. 1개면 하나만 뽑음.*/
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> idxSong = new HashMap<>(); 
        for(int i = 0; i < sortedMap.size(); i++) {
        	String str = sortedMap.get(i).getKey();
        	for(int j = 0; j < genres.length; j++) {
        		if(genres[j].equals(str)) {
        			idxSong.put(j, plays[j]);
        		}        			      			
        	}
        	for(int j = 0; j < 2; j++) {       		
        		int max = 0;
            	int sIndex = 0;
            	for(int idx : idxSong.keySet()) {
            		if(max < idxSong.get(idx)) {
            			max = idxSong.get(idx);
            			sIndex = idx;
            		}else if(max == idxSong.get(idx) && sIndex > idx) {
            			sIndex = idx;
            		}
            	}
            	if(!idxSong.isEmpty()) {
            		idxSong.remove(sIndex);
                	list.add(sIndex);
            	}           	
        	}        	
        	idxSong.clear();
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }        
        return answer;
    }
}
