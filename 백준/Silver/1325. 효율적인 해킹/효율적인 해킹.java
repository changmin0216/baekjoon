

import java.io.*;
import java.util.*;

public class Main {

    static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int a : g[node]) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
    static int n, m, cnt;
    static List<Integer>[] g;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new List[n+1];
        for (int i = 0; i < n + 1; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g[b].add(a);
        }

        int[] result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            cnt = 0;
            visited = new boolean[n+1];
            dfs(i);
            result[i] = cnt;
        }
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i < n + 1; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
