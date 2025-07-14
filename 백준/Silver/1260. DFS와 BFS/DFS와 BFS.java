

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static int[][] graph;

    public static void dfs(int node) {
        visited[node] = true;

        System.out.print(node+" ");
        for (int i = 1; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" ");

            for (int i = 1; i < n + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }
}
