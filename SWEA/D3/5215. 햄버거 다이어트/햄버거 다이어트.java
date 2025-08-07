import java.io.*;
import java.util.*;

public class Solution {
	static int n, l;
	static int[] score;
	static int[] cal;
	static int R;
	static int result;
//	static void comb(int depth, int start, int sum, int calSum) {
//		if (calSum > l) return;
//		if(depth==R) {
//			result = Math.max(result, sum);
//			return;
//		}
//		
//		for (int i=start;i<n;i++) {
//			comb(depth+1, i+1, sum+score[i], calSum+cal[i]);
//		}
//	}
	static void recur(int idx, int scoreSum, int calSum) {
		if (calSum > l) return;
		if (idx==n) {
			result = Math.max(result, scoreSum);
			return;
		}
		
		recur(idx+1, scoreSum+score[idx], calSum+cal[idx]);
		recur(idx+1, scoreSum, calSum);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			score = new int[n];
			cal = new int[n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());				
			}
			
			result = Integer.MIN_VALUE;
//			for (int i=1;i<n+1;i++) {
//				R = i;
//				comb(0, 0, 0, 0);
//				
//			}
			recur(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
