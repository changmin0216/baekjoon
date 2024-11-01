

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<int[]> graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        graph.sort((o1, o2) -> o1[2] - o2[2]);

        long total = 0;
        for (int i = 0; i < m; i++) {
            total += graph.get(i)[2];
        }

        int[] parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        long answer = 0;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = graph.get(i)[0];
            int b = graph.get(i)[1];
            int c = graph.get(i)[2];

            if (find_parent(parent, a) != find_parent(parent, b)) {
                answer+=c;
                cnt+=1;
                union_parent(parent, a, b);
            }
        }
        if (cnt != n - 1) {
            System.out.println(-1);
        }
        else{
            System.out.println(total - answer);
        }

    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a<b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }
}
