class Solution {
    static boolean[] visited;
    static int size;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        size = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer+=1;
            }
        }
        return answer;
    }

    static void dfs(int start, int[][] computers) {
        visited[start] = true;
        for (int i = 0; i < size; i++) {
            if ((i != start) && (computers[start][i] == 1)) {
                if (!visited[i]) {
                    dfs(i, computers);
                }
            }
        }
    }
}