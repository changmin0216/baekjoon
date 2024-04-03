class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String as = Integer.toString(a);
        String bs = Integer.toString(b);

        String qq = as + bs;
        String ww = bs + as;

        if (Integer.parseInt(qq)>=Integer.parseInt(ww)){
            answer = Integer.parseInt(qq);
        }
        else{
            answer = Integer.parseInt(ww);
        }
        return answer;
    }
}