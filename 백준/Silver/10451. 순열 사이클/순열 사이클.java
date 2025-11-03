
import java.io.*;
import java.util.*;


public class Main{
	static List<Integer>[] g;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			g = new List[N+1];
			v = new boolean[N+1];
			for (int i=0;i<N+1;i++) {
				g[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				int b = Integer.parseInt(st.nextToken());
				g[i+1].add(b);
			}
			
			int sum = 0;
			for (int i=1;i<N+1;i++) {
				if (!v[i]) {
					dfs(i);
					sum++;
				}
			}

			System.out.println(sum);
		}
	}
	
	static void dfs(int node) {
		v[node] = true;
		
		for (int i=0;i<g[node].size();i++) {
			int next = g[node].get(i);
			if (!v[next]) dfs(next);
		}
	}
}
