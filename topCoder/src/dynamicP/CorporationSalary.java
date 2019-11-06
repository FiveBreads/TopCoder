package dynamicP;

public class CorporationSalary {
	/*
	 * 대기업의 HR부서에서 일하고 있습니다. 각 직원은 여러 명의 직접적인 매니저나 부하 직원을 가질 수 있습니다. 물론 부하 직원도 부하 직원을 가질 수 잇으며,
	 * 매니저도 매니저를 가질 수 있습니다. X가 A의 매니저, A가 B의 매니저 ... D가 Y의 매니저로 하는 ABCD의 연결이 있다면 직원 X는 직원 Y의 상사라고
	 * 부릅니다. 만약 A가 B의 상사라면 B는 A의 상사일 수 없습니다. 새로운 기업 정책에 따르면 부하 없는 직원의 급여는 1입니다. 그리고 직원이 부하 직원이
	 * 있다면 직원의 급여는 직접적인 부하들의 급여합계와 같습니다. String[] relations가 주어집니다. 이 배열에는 직원 i가 직원j의 직접적인 매니저인
	 * 경우 i번째 요소의 j번째 글자가 'Y'로 되어 있으며 아닌 경우 'N'으로 되어 있습니다. 모든 직원의 급여 합계를 리턴해 주세요.
	 * 
	 * relations 1~50개의 요소가 잇는 배열이며 각 요소는 요소 수와 같은 문자열입니다. 각 문자열은 'Y'와 'N'으로 구성되어 있습니다.
	 * i번째 요소의 j번째 문자는 'N'입니다.
	 * */
	// 물고 들어가면서 메모이제이션을 활용한 다이나믹 프로그래밍 통해 답을 찾자!
	
	private long[] salary;
	
	public long getSalary(int i, String[] relations) {
		if(salary[i] == 0) {
			long salaryz = 0;
			String relation = relations[i];
			for(int j = 0; j < relation.length(); j++) {
				if(relation.charAt(j) == 'Y') {
					salaryz += getSalary(j, relations);
				}				
			}
			
			if(salaryz == 0) salaryz = 1;
			salary[i] = salaryz;
		}
		return salary[i];
	}
	
	public long totalSalary(String[] relations) {
		salary = new long[relations.length];
		long total = 0;
		for(int i = 0; i < relations.length; i++) {
			total += getSalary(i, relations);
		}		
		return total;
	}
	
	public static void main(String[] args) {
		CorporationSalary cc = new CorporationSalary();
		String[] relations = {"NNYN", "NNYN", "NNNN", "NYYN"};
		long a = cc.totalSalary(relations);
		System.out.println("total : " + a);
	}
}
