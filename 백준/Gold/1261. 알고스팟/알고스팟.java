

import java.util.*;
import java.io.*;

public class Main {
    private static class Room implements Comparable<Room>{
        int x;
        int y;
        int bbreak;

        public Room(int y, int x, int bbreak) {
            this.x = x;
            this.y = y;
            this.bbreak = bbreak;
        }

        @Override
        public int compareTo(Room o) {
            return bbreak - o.bbreak; //비교할 얘가 더 크면 음수니까 순서를 안 바꿈 -> 오름차순
        }
    }
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        if (n == 1 && m == 1) {
            System.out.println('0');
        }
        else {
            bfs();
        }

    }

    static void bfs(){
//        Queue<Room> q = new LinkedList<>();
        PriorityQueue<Room> q = new PriorityQueue<>();

        q.add(new Room(1, 1, 0));
        visited[1][1] = true;

        while (!q.isEmpty()) {
            Room cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny == n && nx == m) {
                    System.out.println(cur.bbreak);
                    return;
                }

                if (ny>=1 && ny<=n && nx>=1 && nx<=m){
                    if(!visited[ny][nx]){
                        if(map[ny][nx]==0) {
                            q.add(new Room(ny, nx, cur.bbreak));
                            visited[ny][nx] = true;
                        }
                        else {
                            q.add(new Room(ny, nx, cur.bbreak+1));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }
}
