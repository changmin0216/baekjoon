import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0)+1);
            // if(!map.containsKey(name)) map.put(name, 1);
            // else map.put(name, map.get(name)+1);
        }
        
        for (String name : completion) {
            map.put(name, map.get(name)-1);
        }
        
        String answer = "";
        for (String name : map.keySet()) {
            if (map.get(name)!=0) {
                answer = name;
            }
        } 
        
        // System.out.println(map);
        return answer;
    }
}