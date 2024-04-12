

import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (com == 0) {
                union(a, b);
            }
            else{
                if (find(a) == find(b)) {
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
    public static int find(int x) {
        if (x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

//        if (a != b) {
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
//        }
    }
}
