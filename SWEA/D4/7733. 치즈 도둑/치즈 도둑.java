import java.util.*;
import java.io.*;
public class Solution {
	static int[][] map;
	static int n;
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void dfs(int y, int x) {
		v[y][x] = true;
		
		for (int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<n && 0<=nx&&nx<n) {
				if(map[ny][nx]!=-1 && !v[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = -1;
			for (int day=0;day<=100;day++) {
				for (int i=0;i<n;i++) {
					for (int j=0;j<n;j++) {
						if(map[i][j]==day) {
							map[i][j] = -1;
						}
					}
				}
				
				v = new boolean[n][n];
				int cnt = 0;
				for (int i=0;i<n;i++) {
					for (int j=0;j<n;j++) {
						if(map[i][j]!=-1 && !v[i][j]) {
							dfs(i, j);
							cnt++;
						}
					}
				}
				
				if (result < cnt) result = cnt;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
