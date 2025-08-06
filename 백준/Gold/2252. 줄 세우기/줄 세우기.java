import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] graph;
	static int[] indegree;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new List[n+1];
		for (int i=0;i<n+1;i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		indegree = new int[n+1];
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			
			graph[a].add(b);
			indegree[b]+=1;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i=1;i<n+1;i++) {
			if (indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append(" ");
			for (int a:graph[cur]) {
				if (--indegree[a]==0) {
					q.offer(a);
				}
			}
		}
		
		System.out.println(sb);
	}

}
