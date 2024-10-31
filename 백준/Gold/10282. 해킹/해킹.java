

import java.util.*;
import java.io.*;
public class Main {
    private static class Node implements Comparable<Node> {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist; //만약 비교하는 놈이 더 커 --> 안바꿔 --> 오름차순
        }
    }
    static int n, d, c;
    static int a, b, s;
    static ArrayList<ArrayList<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

//                graph.get(a).add(new int[]{b, s});
                graph.get(b).add(new int[]{a, s});
            }

            dijkstra();
        }
    }
    static void dijkstra(){
        int[] distance = new int[n + 1];
        Arrays.fill(distance, 1000000000);
        distance[c] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.num] < now.dist) {
                continue;
            }

            for (int[] tmp: graph.get(now.num)) {
                int cost = tmp[1] + now.dist;

                if (distance[tmp[0]] > cost) {
                    distance[tmp[0]] = cost;
                    pq.offer(new Node(tmp[0], cost));
                }
            }
        }

        int cnt=1;
        int max=0;
        for (int i = 1; i < n + 1; i++) {
            if (i != c && distance[i] != 1000000000) {
                cnt+=1;
                max = Math.max(max, distance[i]);
            }
        }
        System.out.println(cnt + " " + max);
    }
}
