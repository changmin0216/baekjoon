

import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return weight - o.weight;  //비교할 대상이 더 클때 순서를 빠구지 않는다.(오름차순)
        }
    }

    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight));
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int answer= 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            //사이클을 발생하는 간선은 제외
            if (find(edge.start) != find(edge.end)) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(answer);
        br.close();
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            }
            else{
                parent[x] = y;
            }
        }
    }
}
