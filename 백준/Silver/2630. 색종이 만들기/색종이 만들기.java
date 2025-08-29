
import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] map;
	
	static int white = 0, blue = 0;
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		init();
		recur(0, 0, n);
		
//		int num = map[4][0];
//		for (int i=4;i<)
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void recur(int s_y, int s_x, int size) {
		if (check(s_y, s_x, size)) {
			if(map[s_y][s_x]==1) blue++;
			else white++;
			return;
		}

		recur(s_y, s_x, size/2);
		recur(s_y, s_x+size/2, size/2);
		recur(s_y+size/2, s_x, size/2);
		recur(s_y+size/2, s_x+size/2, size/2);
		
		return;
	}
	
	// 현재 맵이 같은 색인지 확인하는 함수
	static boolean check(int s_y, int s_x, int size) {
//		if (s_y==4 && s_x==0 && size ==4) {System.out.println("hello");}
		
		int num = map[s_y][s_x];
		for (int i=s_y;i<s_y+size;i++) {
			for (int j=s_x;j<s_x+size;j++) {
				if (map[i][j]!=num) return false;
			}
		}
		return true;
	}
}

/*
 * 이차원 배열을 받는 함수를 만들어야 한다.
 * 이차원 배열을 받아서 모든 값이 같은 색인지 확인
 * 만약 같은 값이 아니라면 다시 4등분으로 나눠서 검사
 * 같은 값이면? 현재 종이 색깔 변수 ++
 * 
 */