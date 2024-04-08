import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] d = {-1, 1, 2};
    static int[] visited = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println("0");
            System.out.println(n);
        }
        else {
            bfs();
            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int index = k;

            while (index != n) {
                stack.push(parent[index]);
                index = parent[index];
            }

            System.out.println(visited[k]);

            StringBuilder sb = new StringBuilder();

            while (!stack.isEmpty()) {
                sb.append(stack.pop() + " ");

            }
            System.out.println(sb.toString());
        }

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int before = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i < 2) next = before + d[i];
                else next = before * d[i];

                if (next == k) {
                    visited[k] = visited[before];
                    parent[next] = before;
                    return;
                }
                else if (0 <= next && next < 100001 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[before] + 1;
                    parent[next] = before;
                }
            }
        }
    }
}
