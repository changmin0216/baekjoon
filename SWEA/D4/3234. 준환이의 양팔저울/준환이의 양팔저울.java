import java.io.*;
import java.util.*;

public class Solution {
	static int n, R, total, cntt;
	static int[] w;
	static boolean[] v;
	static int[] b;
	static void perm(int cnt) {
		if(cnt==n) {
			recur(0,0, 0);
			return;
		}
		
		for (int i=0;i<n;i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = w[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	static void recur(int idx, int left_sum, int right_sum) {
		if(left_sum<right_sum) return;
		if(idx==n) {
			cntt++;
			return;
		}
		
		recur(idx+1, left_sum+b[idx], right_sum);
		recur(idx+1, left_sum, right_sum+b[idx]);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			v = new boolean[n];
			w = new int[n];
			b = new int[n];
			st = new StringTokenizer(br.readLine());
			total = 0;
			for(int i=0;i<n;i++) {
				int v = Integer.parseInt(st.nextToken());
				w[i] = v;
				total+=v;
			}
			
			cntt=0;
			
			perm(0);
			
			sb.append("#").append(tc).append(" ").append(cntt).append("\n");
		}
		System.out.println(sb);
	}
}
