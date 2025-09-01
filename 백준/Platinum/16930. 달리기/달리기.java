

import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static char[][] map;
	static int[][] dp;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = line[j];
			}
		}

		for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

		st = new StringTokenizer(br.readLine());
		int st_y = Integer.parseInt(st.nextToken());
		int st_x = Integer.parseInt(st.nextToken());
		int e_y = Integer.parseInt(st.nextToken());
		int e_x = Integer.parseInt(st.nextToken());

		System.out.println(bfs(st_y - 1, st_x - 1, e_y - 1, e_x - 1));
	}

	/**
	 * 최적화된 BFS 함수
	 * 시간 초과를 해결하기 위해 불필요한 탐색을 중단하는 로직 추가
	 */
	static int bfs(int st_y, int st_x, int e_y, int e_x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{st_y, st_x});
		dp[st_y][st_x] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];

			// 4가지 방향으로 탐색
			for (int i = 0; i < 4; i++) {
				// 최대 K칸까지 이동
				for (int p = 1; p <= k; p++) {
					int ny = y + dy[i] * p;
					int nx = x + dx[i] * p;

					// [최적화 1] 맵 경계를 벗어나거나 벽을 만나면 해당 방향으로 더 이상 탐색하지 않음
					if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == '#') {
						break;
					}

					// [최적화 2] 이미 더 좋은 경로로 방문한 지점을 만났을 경우
					// 현재 경로로 해당 지점 너머를 탐색해봤자 더 좋은 경로가 나올 수 없으므로 탐색 중단
					if (dp[ny][nx] != -1 && dp[ny][nx] < dp[y][x] + 1) {
						break;
					}
					
					// [최적화 3] 이번 BFS 레벨에서 다른 경로로 이미 방문한 경우
					// 큐에 다시 넣을 필요는 없지만, 이 칸을 지나쳐 더 멀리 갈 수는 있으므로 탐색은 계속함
					if (dp[ny][nx] != -1 && dp[ny][nx] == dp[y][x] + 1) {
						continue;
					}

					// 아직 방문하지 않은 새로운 칸이라면 시간 기록 및 큐에 추가
					dp[ny][nx] = dp[y][x] + 1;
					q.offer(new int[]{ny, nx});
				}
			}
		}
		return dp[e_y][e_x];
	}
}
