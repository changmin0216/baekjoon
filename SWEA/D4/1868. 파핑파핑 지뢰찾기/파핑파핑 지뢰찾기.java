
import java.io.*;
import java.util.*;

/*
 * 이중포문으로 돌면서 0인 곳을 찾는다. 0이면 zero_arr에 좌표를 추가
 * zero_arr을 돌면서 클릭
 * 매번 클릭할때 만다 모든 곳이 다 클릭되었는지 확인
 * 다 클릭이 안되었다면 이중 포무을 돌면서 클릭을 진행
 */

public class Solution {
	static int n;
	static int[] dy = {-1,1,0,0,-1,1,1,-1};
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int[][] map;
	static ArrayList<int[]> zero_arr;
	static int g_cnt;
	static boolean find(int y, int x) {
		for (int i=0;i<8;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<n && 0<=nx&&nx<n) {
				if (map[ny][nx]==100) return false;
			}
		}
		return true;
	}
	
	static void click(int y, int x) {
		if (map[y][x]!=-1) return;
		
		int cnt=0;
		for (int i=0;i<8;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<n && 0<=nx&&nx<n) {
				if (map[ny][nx]==100) cnt++;
			}
		}
		
		map[y][x] = cnt;
		g_cnt++;
		if (cnt==0) {
			map[y][x] = 0;
			for (int i=0;i<8;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<n && 0<=nx&&nx<n) {
					click(ny, nx);
				}
			}
		} 
		return;
	}
	
	static boolean check() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(map[i][j]==-1) return false; 
			}
		}
		return true;
	}
	
	static void print() {
		for (int[] a:map) System.out.println(Arrays.toString(a));
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			int ground_cnt = 0;
			for (int i=0;i<n;i++) {
				char[] line = br.readLine().toCharArray();
				for (int j=0;j<n;j++) {
					// 땅 -1, 지뢰 100
					if(line[j] == '.') {
						map[i][j] = -1;
						ground_cnt++;
					} else {
						map[i][j] = 100;
					}
				}
			}
			zero_arr = new ArrayList<>();
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if(map[i][j]==-1) {
						if (find(i, j)) {
							zero_arr.add(new int[] {i, j});
						}
					}
				}
			}
//			for(int[] ar:zero_arr) System.out.println(ar[0]+" "+ar[1]);
//			System.out.println();
			int result = 0;
			boolean flag = false;
			for (int i=0;i<zero_arr.size();i++) {
				int[] now = zero_arr.get(i);
				if (map[now[0]][now[1]]==-1) {
					click(now[0], now[1]);
					result++;
					if (g_cnt==ground_cnt) {
						flag = true;
						break;
					}
//					if (check()) {
//						flag = true;
//						break;
//					}
				}
				
			}
			if (!flag) {
				boolean flag_2 = false;
				for (int i=0;i<n;i++) {
					for (int j=0;j<n;j++) {
						if (map[i][j]==-1) {
							click(i, j);
//							print();
							result++;
							if (g_cnt==ground_cnt) {
								flag = true;
								break;
							}
//							if (check()) {
//								flag_2 =true;
//								break;
//							}
						}
						if (flag_2) break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}