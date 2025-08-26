
import java.io.*;
import java.util.*;
public class Solution {
	static int find_parent(int[] parent, int x) {
		if(parent[x]!=x) parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}
	
	static void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> dist = new ArrayList<>();
			for (int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				dist.add(new int[] {a, b, c});
			}
			dist.sort((o1, o2) -> Integer.compare(o1[2], o2[2]));
			
			int[] parent = new int[v+1];
			for (int i=1;i<v+1;i++) parent[i] = i;
			
			long mst = 0;
			for (int i=0;i<e;i++) {
				int[] cur = dist.get(i);
				if(find_parent(parent, cur[0])!=find_parent(parent, cur[1])) {
					union_parent(parent, cur[0], cur[1]);
					mst+=cur[2];
				}
			}
			sb.append("#").append(tc).append(" ").append(mst).append("\n");
		}
		System.out.println(sb);
	}

}
