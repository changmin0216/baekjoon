import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] g;
    static int[][] result;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int bfs(int y, int x) {
    	int cnt = 0;
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {y, x});
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
        	cnt++;
        	for (int i = 0; i < 4; i++) {
            	
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (g[ny][nx] == g[now[0]][now[1]] + 1) {
                    	q.offer(new int[]{ny, nx});
                    }
                }
            }
    	}
        return cnt;
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
