

import java.io.*;
import java.util.*;

public class Main {
    static int n, tc;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.offer(new int[]{0, 0, map[0][0]});

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]][cur[1]] < cur[2]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if (dist[ny][nx] > map[ny][nx] + cur[2]) {
                        dist[ny][nx] = map[ny][nx] + cur[2];
                        pq.offer(new int[]{ny, nx, dist[ny][nx]});
                    }
                }
            }
        }
        System.out.printf("Problem %d: %d", tc, dist[n-1][n-1]);
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            tc++;
        }
    }
}
