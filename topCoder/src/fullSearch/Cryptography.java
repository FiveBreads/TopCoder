package fullSearch;

import java.util.Arrays;

public class Cryptography {
	/*이게 내가 푼 방식*/
	public long encrytA(int[] numbers) {
		long max = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			long sum = numbers[i] + 1;
			for(int j = 0; j < numbers.length; j++) {
				if(j == i) continue;
				sum *= numbers[j];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	
	/*이게 좀더 깰껌한 방식*/
	public long encrytB(int[] numbers) {
		long max = 1;
		Arrays.sort(numbers);
		numbers[0]++;
		for(int i = 0; i < numbers.length; i++) {
			max *= numbers[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
