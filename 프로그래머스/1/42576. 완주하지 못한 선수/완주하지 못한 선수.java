import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                index = i;
                break;
            }
            index = i+1;
        }
        return participant[index];
    }
}