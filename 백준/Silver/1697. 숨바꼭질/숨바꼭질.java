

import java.util.*;
import java.io.*;

public class Main {
    static int[] visited;
    static int[] d;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        d = new int[]{-1, 1, 2};
        visited = new int[100001];
        if (n == k) {
            System.out.println(0);
        }
        else {
            bfs(n);
        }
    }
     static void bfs(int nun) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(nun);
        visited[nun] = 1;
        while (!queue.isEmpty()) {
            int e = queue.poll();

            for (int i = 0; i < 3; i++) {
                int ne;
                if (i < 2) ne = e + d[i];
                else ne = e * d[i];

                if (ne == k) {
                    System.out.println(visited[e]);
                    return;
                }

                if (ne >= 0 && ne < 100001 && visited[ne] == 0) {
                    queue.add(ne);
                    visited[ne] = visited[e] + 1;
                }
            }
        }
    }
}
