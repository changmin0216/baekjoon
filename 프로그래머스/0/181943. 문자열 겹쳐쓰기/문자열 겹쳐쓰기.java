class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String sub01 = my_string.substring(0, s);
        String sub03 = my_string.substring(s+overwrite_string.length(), my_string.length());
        answer += sub01 + overwrite_string + sub03;
        return answer;
    }
}