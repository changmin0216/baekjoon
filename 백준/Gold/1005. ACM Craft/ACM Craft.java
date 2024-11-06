import java.io.*;
import java.util.*;
public class Main {
    static int t, n, k, w;
    static int[] delay;
    static int[] indegree;
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
    private static void topology_sort() {
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n + 1];

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

                dp[next] = Math.max(dp[next], dp[now] + delay[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        sb.append(dp[w]).append("\n");
    }
}
