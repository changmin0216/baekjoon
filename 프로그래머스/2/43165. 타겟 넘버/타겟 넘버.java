class Solution {
    static int answer;
    static int[] number;
    static int size;
    public int solution(int[] numbers, int target) {
        answer = 0;
        number = numbers;
        size = numbers.length;

        dfs(0, 0, target);
        return answer;
    }

    public void dfs(int depth, int sum, int target){
        if (depth==size){
            if (sum==target){
                answer++;
            }
            return;
        }

        dfs(depth+1, sum+number[depth], target);
        dfs(depth+1, sum-number[depth], target);
    }
}