
import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	
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
		for(int tc=1;tc<=t;tc++) {
			n = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> arr_y = new ArrayList<>();
			ArrayList<Integer> arr_x = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				int y = Integer.parseInt(st.nextToken());
				arr_y.add(y);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				int x = Integer.parseInt(st.nextToken());
				arr_x.add(x);
			}
			
			double e = Double.parseDouble(br.readLine());
			
			boolean[][] visited = new boolean[n][n];
			ArrayList<double[]> dist = new ArrayList<>();
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if (i==j) continue;
					if (visited[j][i]) continue;
					visited[i][j] = true;
					double d = Math.sqrt(Math.pow(arr_y.get(i) - arr_y.get(j), 2) + Math.pow(arr_x.get(i) - arr_x.get(j), 2));
					dist.add(new double[] {i, j, e*d*d});
				}
			}
			dist.sort((o1, o2) -> Double.compare(o1[2], o2[2]));
			
			int[] parent = new int[n];
			for (int i=0;i<n;i++) parent[i] = i;
			double mst = 0.0;
			for (int i=0;i<dist.size();i++) {
				if (find_parent(parent, (int) dist.get(i)[0])!=find_parent(parent, (int) dist.get(i)[1])) {
					union_parent(parent, (int) dist.get(i)[0], (int) dist.get(i)[1]);
					mst+=dist.get(i)[2];
				}
			}
			sb.append("#").append(tc).append(" ").append(Math.round(mst)).append("\n");
		}
		System.out.println(sb);
	}

}
