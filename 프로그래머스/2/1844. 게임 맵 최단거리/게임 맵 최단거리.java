import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0]==n-1 && cur[1]==m-1) return cur[2];
            
            for (int i=0;i<4;i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (0<=ny && ny<n && 0<=nx && nx<m) {
                    if (!visited[ny][nx] && maps[ny][nx]==1) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx, cur[2]+1});
                    }
                }
            }
        }
                       
        return -1;
    }
}