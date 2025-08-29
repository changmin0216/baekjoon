
import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int n;
	static int[][] map;
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i=0;i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for (int j=0;j<n;j++) {
				map[i][j] = line[j] - '0';
			}
		}
	}
	public static void main(String[] args) throws Exception {
		init();
//		sb.append("(");
		recur(0, 0, n);
//		sb.append(")");
		
		System.out.println(sb);
	}
	
	static void recur(int s_y, int s_x, int size) {
		if (check(s_y, s_x, size)) {
			sb.append(map[s_y][s_x]);
			return;
		}
		
		sb.append("(");
		recur(s_y, s_x, size/2);
		recur(s_y, s_x + size/2, size/2);
		recur(s_y+size/2, s_x, size/2);
		recur(s_y+size/2, s_x+size/2, size/2);
		sb.append(")");
	}
	static boolean check(int s_y, int s_x, int size) {
		int num = map[s_y][s_x];
		for (int i=s_y;i<s_y+size;i++) {
			for (int j=s_x;j<s_x+size;j++) {
				if (num!=map[i][j]) return false;
			}
		}
		return true;
	}
}
