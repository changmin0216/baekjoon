
import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int n;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for (int j=0;j<n;j++) {
				map[i][j] = line[j] - '0';
			}
		}		
	}
	
	static int bfs() {
		int[][] dp = new int[n][n];
		for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);
		
		//출발처리
		dp[0][0] = 0;
		
		//큐 자료구조
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		
		//bfs시작
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i=0;i<4;i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if (0<=ny&&ny<n && 0<=nx&&nx<n) {
					// 아직 방문X
					if (dp[ny][nx]==-1 || dp[ny][nx] > dp[now[0]][now[1]] + map[ny][nx]) {
						dp[ny][nx] = dp[now[0]][now[1]] + map[ny][nx];
						q.offer(new int[] {ny, nx});
					}
				}
			}
		}
		return dp[n-1][n-1];
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			init();
			
			int result = Integer.MAX_VALUE;
			result = Math.min(result, bfs());
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
}