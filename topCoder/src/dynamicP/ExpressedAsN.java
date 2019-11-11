package dynamicP;
import java.util.*;
public class ExpressedAsN {
	int answer = -1;

    public int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }
    /*pos = 5의 갯수, num = number와 비교될 수 */
    public void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8) // 제약조건에서 5의 개수는 8개까지 가능하다고 햇음.
            return;
        if (num == number) { //연산을 했더니 지금까지 한거랑 number랑 같다.
            if (pos < answer || answer == -1) { //answer에 있는 값이 -1, 즉 내가 처음 number와 같은 값이면 answer에 저장. 
                //System.out.println(s);			이미 answer에 값이 있는데 내가 더 작은값이면 answer를 나로 변경한다.
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) { //pos의 값이 8까지 이므로 i는 8까지.
            nn=nn*10+n;// 5, 55, 555, ..., 55555555 순으로 연산이 진행된다.
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
    }
}
