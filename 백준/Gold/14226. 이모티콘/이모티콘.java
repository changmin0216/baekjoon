import java.util.*;
import java.io.*;

public class Main {
    static int s;
    static boolean[][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        bfs(s);
    }

    static void bfs(int s) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 0, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.value == s) {
                System.out.println(now.time);
                return;
            }

            //1. 클립보드에 저장
            q.offer(new Point(now.value, now.value, now.time + 1));

            //2. 클립보드에 있는 이모티콘 화면에 모두 붙여넣기
            if (now.clip != 0 && now.value + now.clip <= s && !visited[now.clip][now.value + now.clip]) {
                q.offer(new Point(now.value + now.clip, now.clip, now.time + 1));
                visited[now.clip][now.value + now.clip] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제.
            if(now.value >= 1 && !visited[now.clip][now.value-1]) {
                q.offer(new Point(now.value-1, now.clip, now.time + 1));
                visited[now.clip][now.value - 1] = true;
            }
        }
    }
}


class Point {
    int value;
    int clip;
    int time;

    public Point(int value, int clip, int time) {
        this.value = value;
        this.clip = clip;
        this.time = time;
    }
}

