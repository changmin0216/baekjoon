import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x:scoville) pq.offer(x);
        
        boolean flag = true;
        int cnt = 0;
        while(true) {
            if (pq.peek() >= K) break;
            
            if(pq.size()==1) {
                break;
            }
            
            int x = pq.poll();
            if (x >= K) break;
            int y = pq.poll();
            
            int result = x + y*2;
            
            pq.offer(result);
            
            cnt++;
        }
        
        if (pq.size()==1) {
            if (pq.peek()>=K) return cnt;
            else return -1;
        } else{
            return cnt;
        }
    }
}