import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int temp = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0,};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 구분하기!
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) div_island(i, j);
            }
        }
        int bridge_cnt = 200;
        //다리 놓기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //섬이면
                if (map[i][j] != 0) {
                    int idx = map[i][j]; //섬의 번호
                    //상하좌우를 돌아서 섬이 아닌 곳이 있으면
                    //다리를 놓으면 되는거 아님???
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        //범위에 있고 바다가 있으면
                        if ((0 <= ny && ny < n) && (0 <= nx && nx < n) && (map[ny][nx] == 0)) {
                            visited = new boolean[n][n]; //방문 여부 초기화
                            bridge_cnt = Math.min(bridge(ny, nx, idx), bridge_cnt); // 다리를 놓는다.
                        }
                    }

                }
            }
        }

        System.out.println(bridge_cnt);

    }
    static int bridge(int y, int x, int island_num) {
        boolean flag = false;
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(y, x, 0));
        visited[y][x] = true;
        int cnt = 20000;
        while (!queue.isEmpty()) {
            Node e = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = e.y + dy[i];
                int nx = e.x + dx[i];

                if ((0 <= ny && ny < n) && (0 <= nx && nx < n) && (!visited[ny][nx]) && (map[ny][nx] != island_num)) {
                    if (map[ny][nx] == 0){ // 바다야
                        visited[ny][nx] = true;
                        queue.add(new Node(ny, nx, e.len+1));
                    }
                    else { //다른 섬이야
                        flag = true;
                        cnt = e.len+1;
                        break;
                    }
                }
            }
            if (flag){
                break;
            }
        }
        return cnt;
    }

    static void div_island(int y, int x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] =true;
        map[y][x]+=temp;

        while (!q.isEmpty()) {
            int[] e = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = e[0] + dy[i];
                int nx = e[1] + dx[i];

                if ((0 <= ny && ny < n) && (0 <= nx && nx < n) && (map[ny][nx] == 1)) {
                    if (!visited[ny][nx]) {
                        map[ny][nx]+=temp;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        temp += 1;
    }
}

class Node {
    int y, x, len;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    Node(int y, int x, int len) {
        this.y = y;
        this.x = x;
        this.len = len;
    }
}