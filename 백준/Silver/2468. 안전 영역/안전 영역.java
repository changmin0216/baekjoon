
import java.io.*;
import java.util.*;
public class Main{
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		int min = Integer.MAX_VALUE;
		int max = -1;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				
				if (k>max) {
					max = k;
				} 
				if (k<min) {
					min = k;
				}
			}
		}
		int result = -1;
		for (int h=min-1;h<=max;h++) {
			int cnt = 0;
			v = new boolean[n][n];
			
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if (!v[i][j] && map[i][j]>h) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			
			if (result < cnt) {
				result = cnt;
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int y, int x, int h) {
		v[y][x] = true;
		
		for (int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if (0<=ny && ny<n && 0<=nx && nx<n) {
				if (map[ny][nx]>h && !v[ny][nx]) dfs(ny, nx, h);
			}
		}
	}
}