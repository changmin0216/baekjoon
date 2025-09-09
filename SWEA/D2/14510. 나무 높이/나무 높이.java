
import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] tree = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc).append(" ").append(minDays(tree)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int minDays(int[] h) {
		int H = 0;
		for (int x: h) H = Math.max(H, x);
		
		int t = 0;
		int o = 0;
		for (int x:h) {
			int d = H-x;
			t+=d/2;
			o+=d%2;
		}

		while(t > o+1) {
			t-=1;
			o+=2;
		}
		
		if (o > t) {
			return o*2-1;
		} else return t*2;
	}

}
