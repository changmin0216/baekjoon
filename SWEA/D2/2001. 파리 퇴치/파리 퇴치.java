import java.io.*;
import java.util.*;

public class Solution {
//					상하좌우, 	 	좌상, 좌하, 우하, 우상
	static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	static int[][] map;
	static int n, m, result;
	
	static void sol(int y, int x) {
		int sum = map[y][x];
		for (int i=0;i<4;i++) {
			for (int k = 1;k<m;k++) {
				int ny = y + dy[i]*k;
				int nx = x + dx[i]*k;
				
				if (0<=ny&&ny<n && 0<=nx&&nx<n) {
					sum+=map[ny][nx];
				}
			}
		}
		result = Math.max(result, sum);
		sum = map[y][x];
		for (int i=4;i<8;i++) {
			for (int k = 1;k<m;k++) {
				int ny = y + dy[i]*k;
				int nx = x + dx[i]*k;
				
				if (0<=ny&&ny<n && 0<=nx&&nx<n) {
					sum+=map[ny][nx];
				}
			}
		}
		result = Math.max(result, sum);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = Integer.MIN_VALUE;
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					int sum = 0;
					for (int k=0;k<m;k++) {
						for(int l=0;l<m;l++) {
							if (0<=i+k&&i+k<n && 0<=j+l&&j+l<n)
							sum+=map[i+k][j+l];
						}
					}
					result = Math.max(result, sum);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
