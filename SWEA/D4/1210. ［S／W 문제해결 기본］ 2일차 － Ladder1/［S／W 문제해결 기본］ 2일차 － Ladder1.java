import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int[] dy = {-1,0,0};
	static int[] dx = {0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			
			map = new int[100][100];
			int y=-1, x=-1;
			for (int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<100;j++) {
					int v = Integer.parseInt(st.nextToken());
					map[i][j] = v;
					if(v==2) {
						y = i;
						x = j;
					}
				}
			}
			
			int d = 0; //상
			while(y!=0) {
				if (d == 0) { //현재 위를 바라보고 있으면
					if (0<=x-1&&x-1<100) {
						if (map[y][x-1]==1) {
							d = 1;
						}
					}
					
					if (0<=x+1&&x+1<100) {
						if (map[y][x+1]==1) {
							d =2;
						}
					}
				}
				
				else {
					if (map[y-1][x] == 1) {
						d = 0;
					}
				}
				
				y = y + dy[d];
				x = x + dx[d];
			}
			sb.append("#").append(t).append(" ").append(x).append("\n");
		}
		System.out.println(sb);
	}
}

//#1 67
//#2 45
//#3 39
//#4 24
//#5 91
//#6 93
//#7 90
//#8 4
//#9 99
//#10 35

