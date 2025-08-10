

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int target_y, target_x, start_y, start_x;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int result = 0;
    static boolean bfs(int y, int x, int depth) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x, depth});
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == target_y && cur[1] == target_x) {
                result = depth;
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx]) {
                    if (map[ny][nx] == '1') {
                        map[ny][nx] = '0';
                        visited[ny][nx] = true;
                    }
                    else {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }

        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        start_y = Integer.parseInt(st.nextToken()) - 1;
        start_x = Integer.parseInt(st.nextToken()) - 1;
        target_y = Integer.parseInt(st.nextToken()) - 1;
        target_x = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int cnt = 1;
        while (true) {
            if (bfs(start_y, start_x, cnt)) {
//                for (char[] c:map) System.out.println(Arrays.toString(c));
                break;
            }
//            for (char[] c:map) System.out.println(Arrays.toString(c));
//            System.out.println();
            cnt++;
        }
        System.out.println(result);
    }
}
