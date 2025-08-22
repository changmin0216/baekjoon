

import java.io.*;
import java.util.*;
public class Main {
	static int n,m,x;
	static List<int[]>[] g;
	static int[] dist;
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {x, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (dist[cur[0]] < cur[1]) continue;
			
			for (int[] next: g[cur[0]]) {
				int cost = next[1] + cur[1];
				if (dist[next[0]] > cost) {
					dist[next[0]] = cost;
					pq.offer(new int[] {next[0], cost});
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		g = new List[n+1]; for (int i=0;i<n+1;i++) g[i] = new ArrayList<>();
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
//			boolean flag = false;
//			for (int j=0;j<g[a].size();j++) {
//				if (g[a].get(j)[0] == b) {
//					flag = true;
//					if (g[a].get(j)[1] > c) {
//						g[a].get(j)[1] = c;
//					}
//					break;
//				}
//			}
//			if (!flag) g[a].add(new int[] {b, c});
			// 양방향 추가
            g[a].add(new int[]{b, c});
            g[b].add(new int[]{a, c});
		}
		
		dist = new int[n+1];
		Arrays.fill(dist, (int) Math.pow(10, 7));
		dist[x] = 0;
		dijkstra();
		
		int max = -1;
		for (int i=1;i<n+1;i++) {
			if (dist[i]>max) {
				max = dist[i];
			}
		}
		System.out.println(max*2);
	}
}
