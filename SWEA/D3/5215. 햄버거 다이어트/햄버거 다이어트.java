import java.io.*;
import java.util.*;

public class Solution {
	static int N, L;
	static int[] score;
	static int[] cal;
//	static int R;
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
//	static void recur(int idx, int scoreSum, int calSum) {
//		if (calSum > l) return;
//		if (idx==n) {
//			result = Math.max(result, scoreSum);
//			return;
//		}
//		
//		recur(idx+1, scoreSum+score[idx], calSum+cal[idx]);
//		recur(idx+1, scoreSum, calSum);
//	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			cal = new int[N];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());				
			}
			
//			result = Integer.MIN_VALUE;
//			for (int i=1;i<n+1;i++) {
//				R = i;
//				comb(0, 0, 0, 0);
//			}
//			recur(0, 0, 0);
			int answer = 0;

            // r = 선택 개수 (0개는 의미 없지만 초기 answer=0이라 생략 가능)
            for (int r = 1; r <= N; r++) {
                // P: 0...(N-r)개, 1...r개  => 1의 위치가 선택된 재료
                int[] P = new int[N];
                for (int i = N - r; i < N; i++) P[i] = 1;

                do {
                    int sumScore = 0, sumCal = 0;
                    for (int i = 0; i < N; i++) {
                        if (P[i] == 1) {
                            sumScore += score[i];
                            sumCal   += cal[i];
                            if (sumCal > L) break; // 가지치기(초과면 더 볼 필요 X)
                        }
                    }
                    if (sumCal <= L) answer = Math.max(answer, sumScore);
                } while (nextPermutation(P));
            }
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	private static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i == 0) return false;

        int j = n - 1;
        while (a[i - 1] >= a[j]) j--;
        swap(a, i - 1, j);

        int k = n - 1;
        while (i < k) swap(a, i++, k--);
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

}
