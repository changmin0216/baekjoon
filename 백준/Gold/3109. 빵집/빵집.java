// 1. dfs/bfs로 도달할 수 있는 경로를 저장하고 비교?? -> 불가능
// 2. dp?? 아닌듯?
// 3. 
import java.io.*;
import java.util.*;

public class Main {
	static int r, c,cnt=0;
	static char[][] map;
	
	static boolean dfs(int y, int x) {
		for (int i=0;i<3;i++) {
			int ny = y + dy[i];
			int nx = x + 1;
			
			if(0<=ny&&ny<r && 0<=nx&&nx<c) {
				if (map[ny][nx]=='.') {
					if (nx==c-1) {
						cnt++;
						return true;
					}
					map[ny][nx] = '-';
					if (dfs(ny, nx)) return true;
				}
			}
		}
		return false;
	}
	
	// 우상, 우, 우하
	static int[] dy = {-1, 0, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for (int i=0;i<r;i++) {
			String s = br.readLine();
			for (int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i=0;i<r;i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
}

//.xx..
//..x..
//.....
//...x.
//...x.