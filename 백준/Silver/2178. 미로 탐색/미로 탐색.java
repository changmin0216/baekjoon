
import java.io.*;
import java.util.*;

class Point {
	int y, x, d;
	
	Point(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n, m;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for (int i=0;i<n;i++) {
			String line = br.readLine();
			
			for (int j=0;j<m;j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(0, 0, 1));
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		while (!q.isEmpty()) {
			Point now = q.poll();
			
			if (now.y == n-1 && now.x == m-1) {
				System.out.println(now.d);
			}
			
			for (int i=0;i<4;i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				
				if (0<=ny && ny<n && 0<=nx && nx<m) {
					if (graph[ny][nx] == 1 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new Point(ny, nx, now.d+1));
					}
				}
			}
		}
	}
}