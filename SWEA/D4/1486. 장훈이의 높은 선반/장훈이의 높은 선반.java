import java.io.*;
import java.util.*;
public class Solution {
	static int[] h;
	static int n, m;
	static int result;
	
	static void recur(int idx, int sum) {
		if (idx==n) {
			if (sum>=m) {
				result = Math.min(result, Math.abs(sum-m));
			}
			return;
		}
		
		recur(idx+1, sum+h[idx]);
		recur(idx+1, sum);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			h = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			result = Integer.MAX_VALUE;
			recur(0,0);
			sb.append("#").append(tc+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}