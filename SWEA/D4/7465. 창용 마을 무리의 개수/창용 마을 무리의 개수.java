
import java.io.*;
import java.util.*;
public class Solution {
    static int find_parent(int[] parent, int x) {
        if (parent[x]!=x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a<b){
            parent[b]=a;
        } else parent[a]=b;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parent = new int[n+1];
            for (int i=0;i<n+1;i++) parent[i] = i;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union_parent(parent, a, b);
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < n + 1; i++) {
                set.add(find_parent(parent, i));
            }
            sb.append("#").append(tc+1).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}
