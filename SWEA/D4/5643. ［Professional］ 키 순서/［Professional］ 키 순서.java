
import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			List<Integer>[] g = new List[n+1];
			for (int i=0;i<n+1;i++) g[i] = new ArrayList<>();
			
			List<Integer>[] rg = new List[n+1];
			for (int i=0;i<n+1;i++) rg[i] = new ArrayList<>();
		
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());				
				
				g[a].add(b);
				rg[b].add(a);
			}
			int result = 0;
			for (int i=1;i<=n;i++) {
				boolean[] v = new boolean[n+1];
				boolean[] rv = new boolean[n+1];
				bfs(i, g, v);
				bfs(i, rg, rv);
				
				int cnt = 0;
				for (int j=1;j<=n;j++) {
					if(v[j] || rv[j]) cnt++; 
				}
				if(cnt==n) result++;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int start, List<Integer>[] g, boolean[] v) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int next:g[now]) {
				if (!v[next]) {
					v[next] = true;
					q.offer(next);
				}
			}
		}
	}
}