
import java.util.*;
import java.io.*;

public class Main {
    static int N, R;
    static int[] population;
    static int[] b;
    static boolean[] visited;
    static boolean[] vi;
    static ArrayList<Integer>[] graph;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    static boolean bfs(int start, List<Integer> arr) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        vi[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (!arr.contains(now)) continue;
            for (int a : graph[now]) {
                if (!vi[a]) {
                    vi[a] = true;
                    q.offer(a);
                }
            }
        }
        return true;

    }

    static void comb(int cnt, int start) {
        if(cnt == R) {
            processCombination(Arrays.copyOf(b, R));
            return;
        }

        for (int i = start; i < N + 1; i += 1) {
            if(visited[i]) continue;
            visited[i] = true;
            b[cnt] = i;
            comb(cnt + 1, i);
            visited[i] = false;
        }
    }

    private static void processCombination(int[] ary) {
        List<Integer> left = new ArrayList<>();
        for (int num : ary) left.add(num);

        List<Integer> right = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!left.contains(i)) right.add(i);
        }

        vi = new boolean[N + 1];
        bfs(left.get(0), left);
        for (int v : left) {
            if (!vi[v]) return;
        }

        vi = new boolean[N + 1];
        bfs(right.get(0), right);
        for (int v : right) {
            if (!vi[v]) return;
        }

        int leftSum = 0, rightSum = 0;
        for (int v : left) leftSum += population[v];
        for (int v : right) rightSum += population[v];

        int diff = Math.abs(leftSum - rightSum);
        result = Math.min(result, diff);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i].add(num);
                graph[num].add(i);
            }
        }

        for (int i = 1; i < (N / 2) + 1; i++) {
            R = i;
            visited = new boolean[N + 1];
            b = new int[i];
            comb(0, 1);
        }

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        }
        else {
            System.out.println(-1);
        }
    }
}
