
import java.io.*;
import java.util.*;
public class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[650][650];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            for (int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<m;j++){
                    int v = Integer.parseInt(st.nextToken());

                    map[i+300][j+300] = v;

                    //y좌표, x좌표, 상태, 활성화 값, 생명력 수치
                    if(v!=0) {
                        q.add(new int[]{i+300, j+300, 0, v, v, v});
                    }
                }
            }


            int size=0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
                if (o1[0]-o2[0]==0) {
                    if (o1[1]-o2[1]==0) {
                        return -(o1[4] - o2[4]);
                    }
                    else return o1[1]-o2[1];
                }
                else return o1[0]-o2[0];
            }));

            for (int i = 0; i < k; i++) {
                size = q.size();
                for (int cnt=0;cnt<size;cnt++) {
                    int[] now = q.poll();

                    // 비활성 상태면
                    if (now[2]==0) {
                        now[3]-=1;
                        if (now[3]==0) {
                            now[2]=1;
                        }
                        q.add(now);
                    }

                    // 활성 상태면
                    else{
                        map[now[0]][now[1]] = -1;
                        if (now[4]!=now[5]) {
                            now[5]-=1;
                            if (now[5]!=0) q.add(now);
                        }
                        //활성 상태 & 퍼져 나가지 않았을때
                        for (int d = 0; d < 4; d++) {
                            int ny = now[0] + dy[d];
                            int nx = now[1] + dx[d];

                            if (map[ny][nx]==0) {
                                //어디에 담아둬야 함. 왜냐하면 한 곳에서 경쟁이 일어날 수 있음
                                pq.offer(new int[]{ny, nx, 0, now[4], now[4], now[4]});
                            }
                        }

                        //활성 상태 & 퍼져 나갔을때
                        if (now[4]==now[5]) {
                            now[5]-=1;
                            if (now[5]!=0) q.add(now);
                        }
                    }
                }

                //이제 이동시킬 아이들 체크ㄱㄱ
                int[] prev = null;
                while (!pq.isEmpty()) {
                    int[] now = pq.poll();
                    if (prev==null){
                        map[now[0]][now[1]] = now[3];
                        q.offer(now);

                        prev = now;
                    }
                    else{
                        if (prev[0]==now[0] && prev[1]==now[1]) {
                            continue;
                        }

                        map[now[0]][now[1]] = now[3];
                        q.offer(now);

                        prev = now;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(q.size()).append("\n");
        }
        System.out.println(sb);
    }
}