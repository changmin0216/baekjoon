
import java.io.*;
import java.util.*;
public class Solution {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static HashSet<String> set;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			set = new HashSet<>();
			
			map = new int[4][4];
			for (int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<4;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0;i<4;i++) {
				for (int j=0;j<4;j++) {
					recur(i, j, 0, String.valueOf(map[i][j]));
				}
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	static void recur(int y, int x, int depth, String str) {
		if (depth==6) {
			set.add(str);
			return;
		}
		
		for (int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<=ny&&ny<4 && 0<=nx&&nx<4) {
				
				recur(ny, nx, depth+1, str+String.valueOf(map[ny][nx]));
			}
		}
	}
}