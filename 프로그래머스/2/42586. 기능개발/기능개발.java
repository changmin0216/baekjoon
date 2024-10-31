import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];

        for (int i=0;i<speeds.length;i++){
            int tmp = (100-progresses[i])%speeds[i];
            if (tmp==0){
                days[i] = (100-progresses[i])/speeds[i];
            }
            else{
                days[i] = (100-progresses[i])/speeds[i]+1;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int tmp = 0;
        for (int i=0;i<days.length;i++){
            if (q.isEmpty()){
                q.offer(days[i]);
                tmp=1;
            }
            else if (q.peek()<days[i]){
                int cnt = 0;
                while(!q.isEmpty()){
                    q.poll();
                    cnt+=1;
                }
                answer.add(cnt);
                q.offer(days[i]);
            }
            else{
                q.offer(days[i]);
            }
        }
        if (!q.isEmpty()) {
            answer.add(q.size());
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}