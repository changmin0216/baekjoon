import java.io.*;
import java.util.*;

public class Solution {
    static int N, cnt;
    static int[][] g;
    static int[][] result;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x) {
    	cnt++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                if (g[ny][nx] == g[y][x] + 1) {
                    dfs(ny, nx);
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            g = new int[N][N];
            result = new int[N][N];
			for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result_num = -1;
            int result_cnt = Integer.MIN_VALUE;
            
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                	cnt = 0;
                    dfs(i, j);
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
