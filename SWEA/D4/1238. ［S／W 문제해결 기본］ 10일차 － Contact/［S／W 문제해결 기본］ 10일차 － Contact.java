import java.io.*;
import java.util.*;
public class Solution{
	static int n, start, result, max_depth;
	static List<Integer>[] g;
	static boolean[] v;
	
	static void bfs(int node) {
		v = new boolean[101];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[node] = true;
		q.offer(new int[] {node, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (max_depth < cur[1]) {
				max_depth = cur[1];
				result = cur[0];
			}
			else if(max_depth == cur[1]) {
				if(result < cur[0]) result = cur[0];
			}
			
			for (Integer a:g[cur[0]]) {
				if(!v[a]) {
					v[a] = true;
					q.offer(new int[] {a, cur[1]+1});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			g = new List[101];
			result = -1;
			max_depth = -1;
			for (int i=0;i<101;i++) g[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				g[a].add(b);
			}
			bfs(start);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}