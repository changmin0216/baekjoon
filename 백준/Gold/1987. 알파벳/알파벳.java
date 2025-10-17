
import java.io.*;
import java.util.*;
public class Main{
	static int R, C;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] map;
	static int max;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		HashSet<Character> set = new HashSet<>();
		int[][] visited = new int[R][C];
		visited[0][0] = 1;
		set.add(map[0][0]);
		
		max = -1;
		dfs(0, 0, set, visited);
		System.out.println(max);
	}
	
	static void dfs(int y, int x, HashSet<Character> set, int[][] visited) {
		max = Math.max(max, visited[y][x]);
		
		for (int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<=ny && ny <R && 0<=nx && nx<C) {
				if (!set.contains(map[ny][nx]) && visited[ny][nx]==0) {
					set.add(map[ny][nx]);
					visited[ny][nx] = visited[y][x] + 1;
					dfs(ny, nx, set, visited);
					set.remove(map[ny][nx]);
					visited[ny][nx] = 0;
				}
			}
		}
	}
}
