
import java.io.*;
import java.util.*;
public class Solution {
	static int d, w, k;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int[][] film = new int[d][w];
			for (int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<w;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			recur(0, film, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void recur(int depth, int[][] film, int cnt) {
		if(depth==film.length) {
			
			if (check(film, k)) {
//				for (int[] a:film) System.out.println(Arrays.toString(a));
//				System.out.println(cnt);
//				System.out.println();
				
				result = Math.min(result, cnt);
			}
			return;
		}
		
		if (cnt > result) return;
		
		int[][] tmp = new int[d][w];
		for (int i=0;i<d;i++) {
			for (int j=0;j<w;j++) {
				tmp[i][j] = film[i][j];
			}
		}
		
		int[][] tmp2 = new int[d][w];
		for (int i=0;i<d;i++) {
			for (int j=0;j<w;j++) {
				tmp2[i][j] = film[i][j];
			}
		}
		
		//안 바꿨을 
		recur(depth+1, tmp, cnt);
		//행을 다 1로 바꾸자
		for (int i=0;i<w;i++) {
			film[depth][i] =1;
		}
		recur(depth+1, film, cnt+1);
		//행을 다 0로 바꾸자
		for (int i=0;i<w;i++) {
			tmp2[depth][i] =0;
		}
		
		recur(depth+1, tmp2, cnt+1);
	}
	
	static boolean check(int[][] film, int k) {
		int n = film.length;
		int m = film[0].length;
		
		for (int x=0;x<m;x++) {
			int cnt = 0;
			int prev = film[0][x];
			for (int y=0;y<n;y++) {
				if (prev==film[y][x]) {
					cnt++;
				} else {
					cnt = 1;
					prev = film[y][x];
				}
				
				if (cnt==k) break;
			}
			if (cnt<k) return false;
		}
		return true;
	}
}

/*
 * 모든 경우의 수를 다 해본다
 * 	1. 해당 줄을 1로 다바꾸고 다음 줄로
 * 	2. 해당 줄을 0으로 다 바꾸고 다음 줄로
 *  3. 해당 줄을 안 바꾸고 다음 줄로
 * 각 줄마다 3번의 동작 3**13 --> 10^6*20
 */

//1
//6 8 3
//0 0 1 0 1 0 0 1
//0 1 0 0 0 1 1 1
//0 1 1 0 0 0 0 0
//1 1 1 1 0 0 0 1
//0 1 1 0 1 0 0 1
//1 0 1 0 1 1 0 1