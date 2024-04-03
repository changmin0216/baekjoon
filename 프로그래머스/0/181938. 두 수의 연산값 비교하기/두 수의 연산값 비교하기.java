class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        String ab = Integer.toString(a) + Integer.toString(b);

        int temp = 2 * a * b;

        if (Integer.parseInt(ab) >= temp) 
            answer = Integer.parseInt(ab);
        else 
            answer = temp;
        
        return answer;
    }
}