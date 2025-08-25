

import java.io.*;
import java.util.*;
public class Solution {
	static int find_parent(int[] parent, int x) {
		if (parent[x]!=x) {
			parent[x] = find_parent(parent, parent[x]);
		}
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
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] parent = new int[n+1];
			for (int i=1;i<n+1;i++) {
				parent[i] = i;
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cmd==0) {
					union_parent(parent, a, b);
				} else {
					if (find_parent(parent, a)==find_parent(parent, b)) {
						sb.append(1);
					} else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
