import java.io.*;
import java.util.*;

public class Main {
    static int n; //정점의 개수
    static ArrayList<ArrayList<Integer>> adj; //인접 리스트
    static boolean[] visit; //방문여부
    static int[] answer; //정답순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        visit = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        if (answer[1] != 1) {
            System.out.println("0");
            return;
        }
        bfsCheck(1);
    }

    public static void bfsCheck(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        int index = 2;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int count = 0;
            for (int next : adj.get(cur)) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                }
            }

            for (int i = index; i < index + count; i++) {
                if (!visit[answer[i]]) {
                    System.out.println("0");
                    return;
                }
                else {
                    queue.offer(answer[i]);
                }
            }
            index += count;
        }
        System.out.println("1");
    }
}