//package a0821;
//import java.io.*;
//import java.util.*;
//public class Solution_professional_키순서_서울_8반_이창민 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//		
//		int t = Integer.parseInt(br.readLine());
//		for(int tc=1;tc<=t;tc++) {
//			int n = Integer.parseInt(br.readLine());
//			int m = Integer.parseInt(br.readLine());
//			
//			int[][] dist = new int[n+1][n+1];
//			for (int i=1;i<n+1;i++) Arrays.fill(dist[i], 10000);
//			for (int i=1;i<n+1;i++) {
//				dist[i][i] = 0;
//			}
//			
//			for (int i=0;i<m;i++) {
//				st = new StringTokenizer(br.readLine());
//				
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				
//				dist[a][b] = 1;
//			}
//			
//			for (int k=1;k<n+1;k++) {
//				for (int i=1;i<n+1;i++) {
//					for (int j=1;j<n+1;j++) {
//						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
//					}
//				}
//			}
//
//			for (int i=1;i<n+1;i++) {
//				for (int j=1;j<n+1;j++) {
//					if (dist[i][j] == 10000) {
//						if (dist[j][i]!=10000) dist[i][j] = dist[j][i];
//					}
//				}
//			}
//			
//			int cnt = 0;
//			for (int i=1;i<n+1;i++) {
//				boolean flag = false;
//				for (int j=1;j<n+1;j++) {
//					if (dist[i][j] == 10000) {
//						flag = true;
//						break;
//					}
//				}
//				if(!flag) cnt++;
//			}
//			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
//		}
//		System.out.println(sb);
//	}
//
//}

import java.io.*;
import java.util.*;
public class Solution {
	static List<Integer>[] graph;
	static List<Integer>[] graph_reverse;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			graph = new List[n+1]; for (int i=1;i<n+1;i++) graph[i] = new ArrayList<>();
			graph_reverse = new List[n+1]; for (int i=1;i<n+1;i++) graph_reverse[i] = new ArrayList<>();
			
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph_reverse[b].add(a);
			}
			
			int result=0;
			for (int i=1;i<n+1;i++) {
				int cnt = bfs(i, graph, n);
				int cnt_reverse = bfs(i, graph_reverse, n);
				
				if (cnt+cnt_reverse == n-1) result++;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static int bfs(int start, List<Integer>[] g, int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[n+1];
		q.offer(start);
		v[start] = true;
		
		int cnt = -1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			
			for (int node:g[cur]) {
				if (!v[node]) {
					v[node] = true;
					q.offer(node);
				}
			}
		}
		return cnt;
	}
}
