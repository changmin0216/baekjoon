import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static void dfs(int v) {
        visited[v] = true;

        for (int a : graph[v]) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }
        int[] result = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            visited = new boolean[n + 1];
            dfs(i);

            for (int j = 1; j < n + 1; j++) {
                if (visited[j]) cnt += 1;
            }
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
