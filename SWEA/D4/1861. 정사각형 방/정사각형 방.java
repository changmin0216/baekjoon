import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] g;
    static int[][] dp; 
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int dfs(int y, int x) {
    	
        if (dp[y][x] != 0) return dp[y][x];
        
        dp[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                if (g[ny][nx] == g[y][x] + 1) {
                    dp[y][x] = 1 + dfs(ny, nx);
                    break;
                }
            }
        }
        return dp[y][x];
    }
    
    static int bfs(int y, int x) {
    	if (dp[y][x] != 0) return dp[y][x];
    	
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	dp[y][x] = 1;
    	q.offer(new int[] {y, x});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		
    		for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (g[ny][nx] == g[y][x] + 1) {
                        dp[y][x] = 1 + bfs(ny, nx);
                        q.offer(new int[] {ny, nx});
                        break;
                    }
                }
    		}
    	}
    	return dp[y][x];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            g = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result_num=0, result_cnt=-0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = bfs(i, j);
                    if (result_cnt < cnt || (result_cnt == cnt && result_num > g[i][j])) {
                    	result_cnt = cnt;
                    	result_num = g[i][j];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result_num).append(" ").append(result_cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}
