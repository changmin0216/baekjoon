import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};	
	static boolean bfs(int y, int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		
		visited = new boolean[100][100];
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if (map[now[0]][now[1]] == 3) {
				return true;
			}
			for (int i=0;i<4;i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if (0<=ny&&ny<100 && 0<=nx&&nx<100 && map[ny][nx]!=1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		
		return false;
	}
	
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			
			map = new int[100][100];
			
			int start_y = -1, start_x = -1;
			for (int i=0;i<100;i++) {
				String st = br.readLine();
//				st = new StringTokenizer(br.readLine());
				for (int j=0;j<100;j++) {
					int v = st.charAt(j) - '0';
					if (v==2) {
						start_y = i;
						start_x = j;
					}
					map[i][j] = v;
				}
			}
			
			int result = 0;
			if (bfs(start_y, start_x)) result = 1;
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
