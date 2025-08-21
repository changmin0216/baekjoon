

import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	static int[][] map;
	static int[] dy = {1, 1, -1, -1};
	static int[] dx = {-1, 1, 1, -1};
	static int w, h;
	static boolean[] v;
	static int sol(int y, int x, int max_w, int max_h) {
		int d = 0;
		v = new boolean[101];
		int result = 0;
		
		boolean w = true;
		boolean h = false;
		
		int w_cnt = 1;
		int h_cnt = 1;
		while(true) {
			if(d==4) break;
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (0<=ny&&ny<n && 0<=nx&&nx<n) {
				if(!v[map[ny][nx]]) {
					v[map[ny][nx]] = true;
					result++;
//					System.out.println(result);
//					System.out.println();
				}
				else return -2;
			} else return -2;
			
			y = ny;
			x = nx;
			
			if(w) w_cnt++;
			else h_cnt++;
			
			if (w_cnt == max_w) {
				d+=1;
				w = !w;
				h = !h;
				w_cnt=1;
			} else if (h_cnt == max_h) {
				d+=1;
				w = !w;
				h = !h;
				h_cnt=1;
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = -1;
			for (w=2;w<=n-1;w++) {
				for (h=2;h<=n-1;h++) {
					for (int i=0;i<n;i++) {
						for (int j=0;j<n;j++) {
							result = Math.max(sol(i, j, w, h), result);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}