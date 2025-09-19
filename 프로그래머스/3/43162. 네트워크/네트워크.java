class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int node, int[][] comp, boolean[] visited) {
        visited[node] = true;
        
        for (int i=0;i<comp.length;i++) {
            if (comp[node][i] == 1 && !visited[i]) dfs(i, comp, visited);
        }
    }
}