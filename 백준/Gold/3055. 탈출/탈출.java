

import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static boolean[][] visited;
    static int time;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] graph;
    static Queue<int[]> q;
    static Queue<int[]> q_water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];
        q = new LinkedList<>();
        q_water = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char tmp = s.charAt(j);
                if (tmp=='S'){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                else if (tmp=='*'){
                    q_water.offer(new int[]{i, j});
                }
                graph[i][j] = tmp;
            }
        }

        time = 0;
        while (!q.isEmpty()) {
            time+=1;
            water();
            if (bfs()) {
                return;
            }
        }
        System.out.println("KAKTUS");
    }

    static boolean bfs() {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            int[] next = q.poll();

            for (int k = 0; k < 4; k++) {
                int ny = next[0] + dy[k];
                int nx = next[1] + dx[k];

                if (ny >= 0 && ny < r && nx >= 0 && nx < c && !visited[ny][nx]) {
                    if (graph[ny][nx]=='D') {
                        System.out.println(time);
                        return true;
                    }
                    if (graph[ny][nx]=='.') {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return false;
    }
    static void water() {
        int len = q_water.size();
        for (int i = 0; i < len; i++) {
            int[] next = q_water.poll();

            for (int k = 0; k < 4; k++) {
                int ny = next[0] + dy[k];
                int nx = next[1] + dx[k];

                if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                    if (graph[ny][nx]=='.') {
                        graph[ny][nx] = '*';
                        q_water.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
