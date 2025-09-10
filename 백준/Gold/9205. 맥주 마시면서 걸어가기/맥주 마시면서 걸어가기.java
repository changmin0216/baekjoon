
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] point = new int[n+2][2];
			
			st = new StringTokenizer(br.readLine());
			point[0][0] = Integer.parseInt(st.nextToken());
			point[0][1] = Integer.parseInt(st.nextToken());
			
			for (int i=1;i<n+1;i++) {
				st = new StringTokenizer(br.readLine());
				
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			point[n+1][0] = Integer.parseInt(st.nextToken());
			point[n+1][1] = Integer.parseInt(st.nextToken());			
			
			if (bfs(point)) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]); 
	}
	
	static boolean bfs(int[][] p) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[p.length];
		q.offer(p[0]);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == p[p.length-1][0] && now[1] == p[p.length-1][1]) return true;
			
			for (int i=0;i<p.length;i++) {
				if (!visited[i] && dist(now, p[i])<=1000) {
					visited[i] = true;
					q.offer(p[i]);
				}
			}
		}
		return false;
	}
}