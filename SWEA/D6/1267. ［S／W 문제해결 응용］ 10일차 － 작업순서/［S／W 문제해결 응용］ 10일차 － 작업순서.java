import java.io.*;
import java.util.*;

/*
 * 위상 정렬 알고리즘을 사용하면 풀릴 것 같다.
 * 10개의 테케
 * 첫번째 줄에는 정점의 개수(V)와 간선의 개수(E)가 주어짐
 * indegree 배열, List<Integer> graph
 * 큐에서 뽑을 때마다 sb에 추가하기, 마지막에 \n 추가하는거 잊지 않기
 * topology_sort 함수 만들기(파라미터X)
 */
public class Solution {
	static int[] indegree;
	static List<Integer>[] graph;
	static StringBuilder sb;
	static void topologt_sort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i=1;i<indegree.length;i++) {
			if (indegree[i]==0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int node: graph[cur]) {
				indegree[node]-=1;
				if(indegree[node]==0) q.offer(node);
			}
		}
		sb.append("\n");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		for (int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			indegree = new int[v+1];
			graph = new List[v+1]; for (int i=0;i<v+1;i++) graph[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<e;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				indegree[b]+=1;
				graph[a].add(b);
			}
			
			sb.append("#").append(tc).append(" ");
			topologt_sort();
		}
		System.out.println(sb);
	}
}
