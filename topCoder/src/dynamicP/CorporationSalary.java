package dynamicP;

public class CorporationSalary {
	/*
	 * ������ HR�μ����� ���ϰ� �ֽ��ϴ�. �� ������ ���� ���� �������� �Ŵ����� ���� ������ ���� �� �ֽ��ϴ�. ���� ���� ������ ���� ������ ���� �� ������,
	 * �Ŵ����� �Ŵ����� ���� �� �ֽ��ϴ�. X�� A�� �Ŵ���, A�� B�� �Ŵ��� ... D�� Y�� �Ŵ����� �ϴ� ABCD�� ������ �ִٸ� ���� X�� ���� Y�� �����
	 * �θ��ϴ�. ���� A�� B�� ����� B�� A�� ����� �� �����ϴ�. ���ο� ��� ��å�� ������ ���� ���� ������ �޿��� 1�Դϴ�. �׸��� ������ ���� ������
	 * �ִٸ� ������ �޿��� �������� ���ϵ��� �޿��հ�� �����ϴ�. String[] relations�� �־����ϴ�. �� �迭���� ���� i�� ����j�� �������� �Ŵ�����
	 * ��� i��° ����� j��° ���ڰ� 'Y'�� �Ǿ� ������ �ƴ� ��� 'N'���� �Ǿ� �ֽ��ϴ�. ��� ������ �޿� �հ踦 ������ �ּ���.
	 * 
	 * relations 1~50���� ��Ұ� �մ� �迭�̸� �� ��Ҵ� ��� ���� ���� ���ڿ��Դϴ�. �� ���ڿ��� 'Y'�� 'N'���� �����Ǿ� �ֽ��ϴ�.
	 * i��° ����� j��° ���ڴ� 'N'�Դϴ�.
	 * */
	// ���� ���鼭 �޸������̼��� Ȱ���� ���̳��� ���α׷��� ���� ���� ã��!
	
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
