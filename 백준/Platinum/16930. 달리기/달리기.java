
import java.io.*;
import java.util.*;
public class Main {
	static int n, m, k;
	static char[][] map;
	static int[][] dp;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dp = new int[n][m];
		
		for (int i=0;i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for (int j=0;j<m;j++) {
				map[i][j] = line[j];
			}
		}
		
		for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);
		
		st = new StringTokenizer(br.readLine());
		int st_y = Integer.parseInt(st.nextToken());
		int st_x = Integer.parseInt(st.nextToken());
		int e_y = Integer.parseInt(st.nextToken());
		int e_x = Integer.parseInt(st.nextToken());
		
		int result = 0;
		result = bfs(st_y-1, st_x-1, e_y-1, e_x-1);
		System.out.println(result);
	}
	
	static int bfs(int st_y, int st_x, int e_y, int e_x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{st_y, st_x});
		dp[st_y][st_x] = 0;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			
			for (int i=0;i<4;i++) {
				for (int p=1;p<=k;p++) {
					int ny = y + dy[i]*p;
					int nx = x + dx[i]*p;
					
					if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == '#') {
						break;
					}
					
					if (dp[ny][nx] != -1 && dp[ny][nx] < dp[y][x] + 1) {
						break;
					}
					
					
					if (dp[ny][nx] != -1 && dp[ny][nx] == dp[y][x] + 1) {
						continue;
					}
					
					dp[ny][nx] = dp[y][x] + 1;
					q.offer(new int[]{ny, nx});
				}
			}
		}
		return dp[e_y][e_x];
	}
}