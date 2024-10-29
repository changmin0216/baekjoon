

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);

        graph = new ArrayList<>(n+1);

        // 각 정점의 인접 리스트 초기화
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        dfs();
        bfs();
    }
    private static void dfs(){
        boolean[] visited = new boolean[n + 1];

        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (!visited[x]) {
                visited[x] = true;
                System.out.print(x+" ");
            }
            for (int val : graph.get(x)) {
                if (!visited[val]) {
                    stack.push(val);
                }
            }
        }
        System.out.println();
    }
    private static void bfs() {

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        // 시작 정점을 스택에 추가
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int node = q.poll();

            System.out.print(node+" ");

            List<Integer> n = graph.get(node);
            for (int i = n.size() - 1; i >= 0; i--) {
                if (!visited[n.get(i)]) {
                    visited[n.get(i)] = true;
                    q.offer(n.get(i));
                }
            }
        }
        System.out.println();
    }
}
