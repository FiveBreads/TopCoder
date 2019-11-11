package dynamicP;
import java.util.*;
public class ExpressedAsN {
	int answer = -1;

    public int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }
    /*pos = 5�� ����, num = number�� �񱳵� �� */
    public void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8) // �������ǿ��� 5�� ������ 8������ �����ϴٰ� ����.
            return;
        if (num == number) { //������ �ߴ��� ���ݱ��� �ѰŶ� number�� ����.
            if (pos < answer || answer == -1) { //answer�� �ִ� ���� -1, �� ���� ó�� number�� ���� ���̸� answer�� ����. 
                //System.out.println(s);			�̹� answer�� ���� �ִµ� ���� �� �������̸� answer�� ���� �����Ѵ�.
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) { //pos�� ���� 8���� �̹Ƿ� i�� 8����.
            nn=nn*10+n;// 5, 55, 555, ..., 55555555 ������ ������ ����ȴ�.
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
    }
}
