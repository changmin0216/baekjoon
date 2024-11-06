

import java.io.*;
import java.util.*;
public class Main {
    static int t, n, k, w;
    static int[] delay;
    static int[] indegree;
//    static Queue<Node> q;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            delay = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            indegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                indegree[b]+=1;
            }

            w = Integer.parseInt(br.readLine());

            topology_sort();
        }
        System.out.println(sb);
    }
//    private static void topology_sort() {
//        Queue<Integer> q = new LinkedList<>();
//        int[] dp = new int[n + 1];  // 각 노드까지 걸린 시간을 기록하는 배열
//        for (int i = 1; i < n + 1; i++) {
//            if (indegree[i] == 0) {
//                q.offer(i);
//            }
//        }
//
//        int time = 0;
//        while (!q.isEmpty()) {
//            int max = -1;
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                int now = q.poll();
//
//                if (now == w) {
//                    sb.append((time + delay[now])).append("\n");
//                    return;
//                }
//
//                max = Math.max(max, delay[now]);
//
//                for (int next : graph.get(now)) {
//                    indegree[next]-=1;
//                    dp[next] = Math.max(dp[next], dp[now] + delay[next]);
//                    if (indegree[next] == 0) {
//                        q.offer(next);
//                    }
//                }
//            }
//            time+=max;
//        }
//    }

    private static void topology_sort() {
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n + 1];  // 각 노드까지 걸린 시간을 기록하는 배열

        // 초기 설정
        for (int i = 1; i < n + 1; i++) {
            dp[i] = delay[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                indegree[next]--;

                // `next`까지 걸린 시간을 업데이트
                dp[next] = Math.max(dp[next], dp[now] + delay[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 목표 노드 `w`까지 걸린 시간을 출력
        sb.append(dp[w]).append("\n");
    }
}
