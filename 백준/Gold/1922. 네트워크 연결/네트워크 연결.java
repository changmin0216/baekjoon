import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[][] graph;
	static int n, m;
	
	static int find_parent(int x) {
		if (parent[x]!=x) {
			parent[x] = find_parent(parent[x]);
		}
		return parent[x];
	}
	
	static void union_parent(int a, int b) {
		a = find_parent(a);
		b = find_parent(b);
		
		if (a<b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		for (int i=0;i<n+1;i++) parent[i]=i;
		graph = new int[m][3];
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[i] = new int[] {a, b, c};
		}
		
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		
		int result = 0;
		for (int i=0;i<m;i++) {
			if (find_parent(graph[i][0])!=find_parent(graph[i][1])) {
				result+=graph[i][2];
				union_parent(graph[i][0], graph[i][1]);
			}
		}
		System.out.println(result);
	}

}
