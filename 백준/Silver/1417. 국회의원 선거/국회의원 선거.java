

import java.util.*;
import java.io.*;

public class Main {
    private static class Can implements Comparable<Can>{
        int num;
        int count;
        public Can(int num, int count){
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Can o) {
            if (o.count > count) {
                return 1;
            } else if (o.count == count) {
                return -1;
            }
            else{
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Can> pq = new PriorityQueue<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (i == 0) {
                result = tmp;
            }
            pq.offer(new Can(i, tmp));
        }
        int answer = 0;

        while (true) {
            Can tmp = pq.poll();
            if (tmp.count > result) {
                result+=1;
                answer+=1;
                pq.offer(new Can(tmp.num, tmp.count-=1));
            }
            else if (tmp.count == result) {
                if (tmp.num == 0) {
                    System.out.println(answer);
                    return;
                }
                else{
                    result+=1;
                    answer+=1;
                    pq.offer(new Can(tmp.num, tmp.count-=1));
                }
            }
            else{
                System.out.println(answer);
                return;
            }

        }
    }
}
