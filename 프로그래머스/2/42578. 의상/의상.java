import java.util.*;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (int i=0;i<clothes.length;i++){
            if (hashmap.get(clothes[i][1])==null) {
                hashmap.put(clothes[i][1], 1);
            }
            else{
                hashmap.put(clothes[i][1], hashmap.get(clothes[i][1]) + 1);
            }
        }

        Set<String> key = hashmap.keySet();

        for (String s : key) {
            answer *= (hashmap.get(s)+1);
        }
        answer-=1;
        return answer;
    }
}