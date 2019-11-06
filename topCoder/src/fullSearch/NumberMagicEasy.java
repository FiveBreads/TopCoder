package fullSearch;
import java.util.*;
public class NumberMagicEasy {
	
	public int theNumber(String answer) {
		String[] card = {"YYYY","YYYN", "YYNY", "YYNN", "YNYY", "YNYN", "YNNY", "YNNN", "NYYY", "NYYN", "NYNY"
				, "NYNN", "NNYY", "NNYN", "NNNY", "NNNN"};		
		for(int i = 0; i < card.length; i++) {
			if(answer.equals(card[i])) 
				return i+1;
		}
		
		return 0;
	}	
	
	/*
	char check(int[] car, int i) {
		for(int x : car) {
			if(x == i)
				return 'Y';			
		}
		return 'N';
	}
	
	public int theNumber(String answer) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8};				
		int[] B = {1, 2, 3, 4, 9, 10, 11, 12};
		int[] C = {1, 2, 5, 6, 9, 10, 13, 14};
		int[] D = {1, 3, 5, 7, 9, 11, 13, 15};
		
		for(int i = 1; i <= 16; i++) {
			if(check(A, i) != answer.charAt(0)) continue;
			if(check(B, i) != answer.charAt(1)) continue;
			if(check(C, i) != answer.charAt(2)) continue;
			if(check(D, i) != answer.charAt(3)) continue;
			return i;
		}		
		return 0;
	}
	*/
}
