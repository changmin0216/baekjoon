import java.io.*;
import java.util.*;
public class Solution {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static int cur_y = -1, cur_x = -1;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int bfs(int y, int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x, 0});
		v[y][x] = true;
		
		int devil_cnt = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			for (char[] a : map) {
//				System.out.println(Arrays.toString(a));
			}
//			System.out.println();
			
			
			if (devil_cnt<cur[2]) {
				devil();
				devil_cnt = cur[2];
			}
			
			if(map[cur[0]][cur[1]] == 'D') {
				return cur[2];
			}
			
			if(map[cur[0]][cur[1]] == '*') {
				continue;
			}
			
			for (int i=0;i<4;i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				
				if (0<=ny&&ny<n && 0<=nx&&nx<m) {
					if(!v[ny][nx] && (map[ny][nx]!='*' && map[ny][nx]!='X')) {
						v[ny][nx] = true;
						q.offer(new int[] {ny, nx, cur[2]+1});
					}
				}
			}
		}
		return -1;
	}
	static void devil() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (map[i][j] == '*') {
					q.offer(new int[] {i, j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i=0;i<4;i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				
				if (0<=ny&&ny<n && 0<=nx&&nx<m) {
					if (map[ny][nx]!='X' && map[ny][nx]!='D') {
						map[ny][nx] = '*';
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			v = new boolean[n][m];
			for (int i=0;i<n;i++) {
				char[] line = br.readLine().toCharArray();
				for (int j=0;j<m;j++) {
					if (line[j]=='S') {
						cur_y = i;
						cur_x = j;
						map[i][j] = '.';
					}
					map[i][j] = line[j];
				}
			}
			
			sb.append("#").append(tc).append(" ");
			int result = bfs(cur_y, cur_x);
			if (result==-1) sb.append("GAME OVER").append("\n");
			else sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
