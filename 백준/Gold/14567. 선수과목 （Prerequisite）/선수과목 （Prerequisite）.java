

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]+=1;
        }

        int[] result = new int[N + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(new int[]{i, 1});
                result[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            result[now[0]] = now[1];

            for (Integer v : graph[now[0]]) {
                indegree[v]-=1;
                if (indegree[v] == 0) {
                    q.offer(new int[]{v, now[1] + 1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
