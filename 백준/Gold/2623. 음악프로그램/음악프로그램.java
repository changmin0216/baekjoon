

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] tmp = new int[size];
            for (int j = 0; j < size; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < size - 1; j++) {
                graph.get(tmp[j]).add(tmp[j+1]);
                indegree[tmp[j+1]]+=1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            answer.add(now);
            for (int num : graph.get(now)) {
                indegree[num]-=1;
                if (indegree[num] == 0) {
                    q.offer(num);
                }
            }
        }
        if (answer.size() != n) {
            System.out.println(0);
        }
        else{
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }
}
