import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            arr.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if (arr.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.size();i++) sb.append(arr.get(i));
        return sb.toString();
    }
}