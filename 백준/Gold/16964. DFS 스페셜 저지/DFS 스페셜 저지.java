

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean flag;
    static int n, idx;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        answer = new int[n];
        visited = new boolean[n+1];
        flag = true;
        idx = 1;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        if (answer[0]!=1){
            System.out.println(0);
            return;
        }

        dfs_solutions(1);


        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static void dfs_solutions(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;

        HashSet<Integer> set = new HashSet<>();
        for (int node : adj.get(start)) {
            if (visited[node]) continue;
            set.add(node);
        }

        if (set.size() == 0) return;

        if(set.contains(answer[idx])) {
            dfs_solutions(answer[idx++]);
        } else {
            flag = false;
        }
    }
}


