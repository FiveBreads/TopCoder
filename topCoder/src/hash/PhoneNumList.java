package hash;

import java.util.*;

public class PhoneNumList {
	public boolean solution(String[] phone_book) {
        boolean answer = true;    
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for(int i = 0; i < phone_book.length; i++){
            int len = phone_book[i].length();
            map.put(phone_book[i], 0);
            for(int j = i + 1; j < phone_book.length; j++){
                map.put(phone_book[j].substring(0, len), j);
            }
            if(map.get(phone_book[i]) != 0){
                answer = false;
                break;
            }
            map.clear();
        }        
        return answer;
    }
}
