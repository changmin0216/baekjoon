import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int[][] graph;
    static int[][] dp;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(i, j), max);
            }
        }
        System.out.println(max);
    }

    private static int dfs(int y, int x) {
        if (dp[y][x]!=-1){
            return dp[y][x];
        }
        dp[y][x] = 1;
        int ny, nx;
        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if (0<=ny && ny<n && 0<=nx && nx<n){
                if (graph[ny][nx] > graph[y][x]) {
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx)+1);
                    dfs(ny, nx);
                }
            }
        }
        return dp[y][x];
    }
}
