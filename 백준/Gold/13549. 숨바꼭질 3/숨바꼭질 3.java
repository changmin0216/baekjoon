import java.util.*;
import java.io.*;

public class Main {
    private static class Point{
        int time;
        int value;

        public Point(int value, int time) {
            this.time = time;
            this.value = value;
        }
    }

    static int n,k;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

//        visited = new boolean[k + 1];

        if (n == k) {
            System.out.println("0");
        }
        else {
            bfs();
        }

    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();

            int next=0;
            int p = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = current.value*2;
                }
                else if (i == 1) {
                    next = current.value-1;
                    p = 1;
                }
                else {
                    next = current.value+1;
                    p=1;
                }
                if (next == k) {
                    System.out.println(current.time+p);
                    return;
                }

                if (next >= 0 && next < 100001) {
                    if (!visited[next]) {
                        q.add(new Point(next, current.time + p));
                        visited[next] = true;
                    }
                }

            }

        }
    }

}

