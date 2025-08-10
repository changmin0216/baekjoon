import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] g;
	static boolean[] visited;
	static void dfs(int node) {
		visited[node] = true;
		
		for(int a:g[node]) {
			if(!visited[a]) dfs(a);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		g = new List[n+1]; for (int i=0;i<n+1;i++) g[i] = new ArrayList<>();
		visited = new boolean[n+1];
		m = Integer.parseInt(br.readLine());
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			g[a].add(b);
			g[b].add(a);
		}
		
		dfs(1);
		
		int result = -1;
		for (int i=1;i<n+1;i++) {
			if(visited[i]) result++;
		}
		System.out.println(result);
	}
}
