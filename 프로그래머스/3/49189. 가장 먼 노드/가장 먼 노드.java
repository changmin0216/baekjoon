import java.util.*;
import java.io.*;

class Solution {
    private static class Node implements Comparable<Node>{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist; //비교하는 얘가 더 크면 음수 -> 안바꿔 -> 오름 차순
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] tmp : edge) {
            edges.get(tmp[0]).add(tmp[1]);
            edges.get(tmp[1]).add(tmp[0]);
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 0));
        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (distance[now.num] < now.dist) {
                continue;
            }

            for (Integer tmp : edges.get(now.num)) {
                if (distance[tmp] > now.dist + 1) {
                    distance[tmp] = now.dist + 1;
                    q.offer(new Node(tmp, now.dist + 1));
                }
            }
        }
        int max = -1;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, distance[i]);
        }
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == max) {
                answer+=1;
            }
        }
        return answer;
    }
}