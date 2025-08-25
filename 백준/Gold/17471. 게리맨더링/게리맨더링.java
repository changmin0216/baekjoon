
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

    // 조합: visited 제거 + i+1 진행
static void comb(int cnt, int start) {
    if (cnt == R) {
        processCombination(Arrays.copyOf(b, R));
        return;
    }
    for (int i = start; i <= N; i++) {
        b[cnt] = i;
        comb(cnt + 1, i + 1);
    }
}

private static void processCombination(int[] ary) {
    boolean[] inLeft = new boolean[N + 1];
    for (int v : ary) inLeft[v] = true;

    boolean[] inRight = new boolean[N + 1];
    for (int i = 1; i <= N; i++) if (!inLeft[i]) inRight[i] = true;

    // 왼쪽 연결성
    vi = new boolean[N + 1];
    int leftStart = -1, rightStart = -1;
    for (int i = 1; i <= N; i++) if (inLeft[i]) { leftStart = i; break; }
    for (int i = 1; i <= N; i++) if (inRight[i]) { rightStart = i; break; }

    if (leftStart == -1 || rightStart == -1) return; // 한쪽이 비면 스킵

    if (!bfs(leftStart, inLeft)) return;

    // 오른쪽 연결성
    vi = new boolean[N + 1];
    if (!bfs(rightStart, inRight)) return;

    // 합계 계산
    int leftSum = 0, rightSum = 0;
    for (int i = 1; i <= N; i++) {
        if (inLeft[i])  leftSum  += population[i];
        else            rightSum += population[i];
    }
    result = Math.min(result, Math.abs(leftSum - rightSum));
}

// BFS: 집합 내부만 방문
static boolean bfs(int start, boolean[] inSet) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.offer(start);
    vi[start] = true;
    int visitedCount = 0;
    int need = 0;
    for (int i = 1; i <= N; i++) if (inSet[i]) need++;

    while (!q.isEmpty()) {
        int now = q.poll();
        if (!inSet[now]) continue;
        visitedCount++;
        for (int nxt : graph[now]) {
            if (!vi[nxt] && inSet[nxt]) {
                vi[nxt] = true;
                q.offer(nxt);
            }
        }
    }
    return visitedCount == need;
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
