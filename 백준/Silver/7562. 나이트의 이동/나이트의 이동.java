
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int l;
    private static boolean[][] visited;

    private static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bfs(x1, y1, x2, y2);
        }
    }

    public static void bfs(int x1, int y1, int x2, int y2){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int ex = e[0];
            int ey = e[1];

            if (ex==x2 && ey==y2){
                System.out.println(map[ex][ey]);
            }

            for (int i = 0; i < 8; i++) {
                int nx = ex + dx[i];
                int ny = ey + dy[i];

                if ((0 <= nx && nx < l) && (0 <= ny && ny < l)) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = map[ex][ey] + 1;
                    }
                }
            }
        }

    }

}
