
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
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[] score = new int[n+1];			
			int[] cal = new int[n+1];
			
			for (int i=1;i<n+1;i++) {
				st = new StringTokenizer(br.readLine());
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp=new int[n+1][l+1];
			for (int i=1;i<n+1;i++) {
				for (int j=0;j<=l;j++) {
					if (j<cal[i]) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = Math.max(dp[i-1][j-cal[i]]+score[i], dp[i-1][j]);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[n][l]).append("\n");
		}
		System.out.println(sb);
	}

}
