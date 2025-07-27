import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        dp[0][0] = graph[0][0];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (dp[ny][nx] == -1) {
                        dp[ny][nx] = dp[now[0]][now[1]] + graph[ny][nx];
                        q.offer(new int[]{ny, nx});
                    } else if (dp[ny][nx] > dp[now[0]][now[1]] + graph[ny][nx]) {
                        dp[ny][nx] = dp[now[0]][now[1]] + graph[ny][nx];
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return dp[N-1][N-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N==0) break;

            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }
            graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(tc).append(": ").append(bfs()).append("\n");
            tc++;
        }
        System.out.println(sb);
    }
}
