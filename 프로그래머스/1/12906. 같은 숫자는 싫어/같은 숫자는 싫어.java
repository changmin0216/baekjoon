import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int tmp = 10;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (tmp!=arr[i]) {
                answer.add(arr[i]);
                tmp = arr[i];
            }
        }
        int[] result = new int[answer.size()];
        for (int i=0;i<result.length;i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}