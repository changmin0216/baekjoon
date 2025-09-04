
import java.io.*;
import java.util.*;

class Atom {
	int y;
	int x;
	int dir;
	int e;
	public Atom(int y, int x, int dir, int e) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
		this.e = e;
	}
}

public class Solution {
	static int n;
	static int answer;
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		map = new int[4001][4001];
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			ArrayDeque<Atom> q = new ArrayDeque<>();
			
			for (int i=0;i<4001;i++) {
				for (int j=0;j<4001;j++) {
					map[i][j] = 0;
				}
			}
			
			answer = 0;
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				q.offer(new Atom((y+1000)*2, (x+1000)*2, dir, k));
			}
			int size = -1;
			while(!q.isEmpty()) {
				size = q.size();
				for (int i=0;i<size;i++) {
					Atom a = q.poll();
					map[a.y][a.x] = 0;
					int ny = a.y + dy[a.dir];
					int nx = a.x + dx[a.dir];
					
					if (valid(ny, nx)) {
						a.y = ny;
						a.x = nx;
						
						map[ny][nx]+=a.e;
						q.offer(a);
					}
				}
				size = q.size();
				for (int i=0;i<size;i++) {
					Atom a = q.poll();
					
					if (map[a.y][a.x]!=a.e) {
						answer+=a.e;
						map[a.y][a.x] = 0;
					} else {
						q.offer(a);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean valid(int y, int x) {
		if (0<=y&&y<4001 && 0<=x&&x<4001) return true;
		return false;
	}
	
}
