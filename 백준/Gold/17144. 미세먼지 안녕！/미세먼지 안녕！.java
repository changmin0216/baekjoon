
import java.io.*;
import java.util.*;

public class Main{
	static int R, C, T;
	static int[][] map;
	static ArrayList<int[]> a;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		a = new ArrayList<>();
		for (int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<C;j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k==-1) a.add(new int[] {i, j});
				map[i][j] = k;				
			}
		}
		
		for (int i=0;i<T;i++) {
			dust();
			air();
		}

		int result = 0;
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if (map[i][j]==-1) continue;
				result+=map[i][j];
			}
		}
		System.out.println(result);
	}
	
	static void dust() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		// 큐에다가 다 넣고 해당 위치를 0으로 바꾸고 
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if (map[i][j]!=0 && map[i][j]!=-1) {
					q.add(new int[] {i, j, map[i][j]});
					map[i][j] = 0;
				}
			}
		}
		
		int[] dy = new int[] {1, -1, 0, 0};
		int[] dx = new int[] {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			int ey = now[0];
			int ex = now[1];
			int v = now[2];
			
			int k = 0;
			for (int i=0;i<4;i++) {
				int ny = ey + dy[i];
				int nx = ex + dx[i];
				
				if (0<=ny && ny<R && 0<=nx && nx<C) {
					if (map[ny][nx]!=-1) {
						map[ny][nx]+=v/5;
						k++;
					}
				}
			}
			
			map[ey][ex]+=v-((v/5)*k);
		}
	}
	
	static void air() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int[] point = a.get(0);
		int uy = point[0];
		
		for (int i=1;i<C;i++) {
			q.add(map[uy][i]);
		}
		
		for (int i=uy-1;i>=0;i--) {
			q.add(map[i][C-1]);
		}
		
		for (int i=C-2;i>=0;i--) {
			q.add(map[0][i]);
		}
		
		for (int i=1;i<uy-1;i++) {
			q.add(map[i][0]);
		}
		
		map[uy][1] = 0;
		for (int i=2;i<C;i++) {
			map[uy][i] = q.poll();
		}
		
		for (int i=uy-1;i>=0;i--) {
			map[i][C-1] = q.poll();
		}
		
		for (int i=C-2;i>=0;i--) {
			map[0][i] = q.poll();
		}
		
		for (int i=1;i<=uy-1;i++) {
			map[i][0] = q.poll();
		}
		// --------------------------------------
		point = a.get(1);
		int dy = point[0];
		
		for (int i=1;i<C;i++) {
			q.add(map[dy][i]);
		}
		
		for (int i=dy+1;i<R;i++) {
			q.add(map[i][C-1]);
		}
		
		for (int i=C-2;i>=0;i--) {
			q.add(map[R-1][i]);
		}
		
		for (int i=R-2;i>dy+1;i--) {
			q.add(map[i][0]);
		}
		
		map[dy][1] = 0;
		
		for (int i=2;i<C;i++) {
			map[dy][i] = q.poll();
		}
		
		for (int i=dy+1;i<R;i++) {
			map[i][C-1] = q.poll();
		}
		
		for (int i=C-2;i>=0;i--) {
			map[R-1][i] = q.poll();
		}
		
		for (int i=R-2;i>=dy+1;i--) {
			map[i][0] = q.poll();
		}
	}
}

/*
 * 확산 함수
 * 큐에다가 다 넣고 해당 위치를 0으로 바꾸고 
 * 큐에서 하나씩 꺼내면서 상하좌우 확산
 * 
 * 순환 함수
*/
