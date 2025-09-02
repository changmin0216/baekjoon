
import java.io.*;
import java.util.*;
public class Solution {
	static int result;
	static int n, m, c;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MIN_VALUE;
			for (int i=0;i<n;i++) {
				for (int j=0;j<n-m+1;j++) {
					sol(i, j);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void sol(int y, int x) {
		int left = find_max(y, x);
		
//		System.out.println(left);
//		System.out.println();
		//현재 행에서 체크ㄱㄱ
		int right = -1;
		for (int i=x+m;i<n-m+1;i++) {
			right = find_max(y, i);
			result = Math.max(result, left+right);
		}
		
		//다음 행에서 체크 ㄱㄱ
		for (int i=y+1;i<n;i++) {
			for (int j=0;j<n-m+1;j++) {
				right = find_max(i, j);
				result = Math.max(result, left+right);
			}
		}
	}
	
	static int max_v;
	static int mmax;
	static int find_max(int y,int x) {
		int[] arr = new int[m];
		for (int i=0;i<m;i++) {
			arr[i] = map[y][x+i];
		}
//		System.out.println(Arrays.toString(arr));
		max_v = -1;
//		mmax = -1;
//		ArrayList<Integer> a = new ArrayList<>();
		recur(arr, 0, 0, 0);
		
		return max_v;
	}
	
	static void recur(int[] arr, int index, int sum,int ssum) {
		if (sum > c) return;
		
		if (index == m) {
//			System.out.println(ssum);
//			System.out.println(sum);
//			System.out.println();
			if (ssum > max_v) {
				max_v = ssum;
			}
			return;
		}
//		value.add(arr[index]);
		recur(arr, index+1, sum+arr[index], ssum+(arr[index]*arr[index]));
//		value.remove(value.size()-1);
		recur(arr, index+1, sum,ssum);		
	}
}

/*
 * 가로 M개 먹음
 * 겹치면 안된다.
 * 다 해보면 되지 않을까??...
 * 하나를 고르고 나머지가 갈수 있는 곳을 고르면 되지 않을까??(이중for문)
 * m개 c범위 확인
 * 배열에서 가장 합이 최대인 경우는 뭘까????
 * 조합인가?
 * 부분집합 파라미터에 배열을 넣을까? 넣고 안넣고
 * 
 * 6 1 9 7    
9 8 5 8
3 4 5 3
8 2 6 7
 */