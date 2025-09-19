import java.util.*;
class Solution {
    static int n;
    static int result;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        result = 0;
        boolean[] selected = new boolean[n];
        dfs(0, selected, target, numbers);
        
        int answer = result;
        return answer;
    }
    
    static void dfs(int depth, boolean[] selected, int target, int[] numbers) {
        if (depth==n) {
            // System.out.println(Arrays.toString(selected));
            int tmp = 0;
            
            for (int i=0;i<n;i++) {
                if (selected[i]) tmp+=numbers[i];
                else tmp-=numbers[i];
            }
            
            if (tmp==target) {
                // System.out.println(Arrays.toString(selected));
                result++;
            }
            return;
        }
        selected[depth] = true;
        dfs(depth+1, selected, target, numbers);
        selected[depth] = false;
        dfs(depth+1, selected, target, numbers);
    }
}