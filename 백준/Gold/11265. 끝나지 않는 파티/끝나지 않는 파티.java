import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		int[][] distance = new int[N][N];
//		for (int i=0;i<N;i++) {
//			Arrays.fill(distance[i], Integer.MAX_VALUE);
//		}
//		for (int i=0;i<N;i++) {
//			distance[i][i] = 0;
//		}
//		
		for (int k=0;k<N;k++) {
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (graph[a-1][b-1]<=c) {
				sb.append("Enjoy other party\n");
			}
			else sb.append("Stay here\n");
		}
		
		System.out.print(sb);
	}
}
