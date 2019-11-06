package simulation;

public class KiwiJuiceEasy {

	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		//capacities & bottles - 2~50
		//capacities ¿ø¼Ò°ª <= 1000000
		//fromId & toId - 1~50		
		int tmp = 0;
		for(int i = 0; i < fromId.length; i++) {			
			int f = fromId[i];
			int t = toId[i];
			
			int vol = Math.min(bottles[f], capacities[t] - bottles[t]);
			
			bottles[f] -= vol;
			bottles[t] += vol;
		}	
		return bottles;
	}
}
