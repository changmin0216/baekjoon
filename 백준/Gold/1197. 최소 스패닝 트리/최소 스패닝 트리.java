
import java.io.*;
import java.util.*;
public class Main {
	static int v, e;
	static List<int[]>[] g;
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		g = new List[v+1];
		for (int i=0;i<v+1;i++) g[i] = new ArrayList<>();
		
		for (int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			g[a].add(new int[] {b, c});
			g[b].add(new int[] {a, c});
		}
	}
	
	static void prim() {
		int[] prim = new int[v+1];
		Arrays.fill(prim, Integer.MAX_VALUE);
		
		boolean[] visited = new boolean[v+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		
		prim[1] = 0;
		pq.offer(new int[] {1, prim[1]});
		
		long mst = 0, cnt=0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int minVertex = now[0];
			int min = now[1];
			
			if(visited[minVertex]) continue;
			mst+=min;
			visited[minVertex] = true;
			if(cnt++ == v-1) break;
			
			for (int[] next:g[minVertex]) {
				if (!visited[next[0]] && prim[next[0]] > next[1]) {
					prim[next[0]] = next[1];
					
					pq.offer(new int[] {next[0], prim[next[0]]});
				}
			}
		}
		System.out.println(mst);
	}
	public static void main(String[] args) throws Exception{
		init();
		prim();
	}

}
