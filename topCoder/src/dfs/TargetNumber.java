package dfs;

public class TargetNumber {
	int answer = 0;
    void dfs(int dept, int res, int target, int[] numbers){
        if(dept == numbers.length){
            if(res == target){
                answer++;
            }
            return;
        }        
        dfs(dept + 1, res - numbers[dept], target, numbers);
        dfs(dept + 1, res + numbers[dept], target, numbers);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }
}
