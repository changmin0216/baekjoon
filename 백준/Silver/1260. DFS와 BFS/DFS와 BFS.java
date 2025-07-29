

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (Integer a : graph[now]) {
                if (!visited[a]) {
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        sb.append(node).append(" ");
        for (Integer a : graph[node]) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs();

        System.out.println(sb);
    }
}
