

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] a;
    static StringBuilder sb;
    static void perm(int cnt) {
        if (cnt==N) {
            for (int v : a) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            a[cnt] = i+1;
            perm(cnt+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        a = new int[N];

        perm(0);
        System.out.print(sb);
    }
}
