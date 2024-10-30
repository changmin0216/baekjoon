import java.util.*;
import java.io.*;

class Solution {
    static int len;
    static int result = 0;
    static int target_num;
    public static int solution(int[] numbers, int target) {
        len = numbers.length;
        target_num = target;
        dfs(0, 0, numbers);
        return result;
    }

    private static void dfs(int num, int depth, int[] numbers) {
        if (depth == len) {
            if (num==target_num){
                result+=1;
            }
            return;
        }
        dfs(num + numbers[depth], depth + 1, numbers);
        dfs(num - numbers[depth], depth + 1, numbers);
    }
}