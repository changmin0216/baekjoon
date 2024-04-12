

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int v : adj[cur]) {
//                System.out.println(v);
                if(!visited[v]){
                    visited[v] = true;
                    parent[v] = cur;
                    q.add(v);
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }
    }

}
