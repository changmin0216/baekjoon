import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, result;
    static List<Integer>[] graph;
    static boolean[] visited;
    static void bfs(int v) {
        visited[v] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{v, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] == 1 || cur[1] == 2) {
                result++;
            }
            for (int i : graph[cur[0]]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(new int[]{i, cur[1] + 1});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        result = 0;
        visited = new boolean[n + 1];
        bfs(1);
        System.out.println(result);
    }
}
