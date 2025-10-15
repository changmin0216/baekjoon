
import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i=0;i<n;i++) {
			char[] c = br.readLine().toCharArray();
			for (int j=0;j<m;j++) {
				map[i][j] = c[j]-'0';
			}
		}		
		System.out.println(bfs());
	}
	
	static int bfs() {
		boolean[][] v = new boolean[n][m];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1});
		v[0][0] = true;
		
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,-1,1};
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if (now[0]==n-1 && now[1]==m-1) {
				return now[2];
			}
			
			for (int i=0;i<4;i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if (0<=ny && ny<n && 0<=nx && nx<m) {
					if (map[ny][nx]==1 && !v[ny][nx]) {
						v[ny][nx] = true;
						q.add(new int[] {ny, nx, now[2]+1});
					}
				}
			}
		}
		return -1;
	}
}
