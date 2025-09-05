
import java.io.*;
import java.util.*;
public class Solution {
	static int d, w, k;
	static int result;
	static int[] selected;
	static int[][] film;
	
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
			
			film = new int[d][w];
			for (int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<w;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new int[d];
			Arrays.fill(selected, -1);
			
			int answer;
			
			result = Integer.MAX_VALUE;
			recur(0, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void recur(int depth, int cnt) {
		if(depth==film.length) {
			
			if (check(film, k)) {
				result = Math.min(result, cnt);
			}
			return;
		}
		
		if (cnt > result) return;
		
		
		
		//안 바꿨을 
		recur(depth+1, cnt);
		//행을 다 1로 바꿔
		selected[depth] = 1;
		recur(depth+1, cnt+1);
		selected[depth] = 0;
		//행을 다 0로 바꾸자
		recur(depth+1, cnt+1);
		// 원복
		selected[depth] = -1;
	}
	
	static boolean check(int[][] film, int k) {
		if(k==1) return true;
		
		
		int n = film.length;
		int m = film[0].length;
		
		for (int x=0;x<m;x++) {
			int cnt = 1;
	        int prev;

	        // 첫 행 값 구하기
	        if (selected[0] == -1) {
	            prev = film[0][x];
	        } else {
	            prev = selected[0];
	        }
	        
	        boolean ok = false;

	        for (int y = 1; y < n; y++) {
	            int cur;
	            if (selected[y] == -1) {
	                cur = film[y][x];
	            } else {
	                cur = selected[y];
	            }

	            if (prev == cur) {
	                cnt++;
	                if (cnt == k) {
	                    ok = true;
	                    break;
	                }
	            } else {
	                prev = cur;
	                cnt = 1;
	            }
	        }

	        if (!ok) return false; // 이 열이 불합격이면 전체 실패
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