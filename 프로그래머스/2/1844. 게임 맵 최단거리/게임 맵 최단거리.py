from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    q = deque()
    q.append((0, 0))
    
    visited = [[-1]*m for _ in range(n)]
    visited[0][0] = 1
    
    while q:
        ey, ex = q.popleft()
        
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            
            if 0<=ny<n and 0<=nx<m:
                if maps[ny][nx] == 1 and visited[ny][nx] == -1:
                    visited[ny][nx] = visited[ey][ex] + 1
                    q.append((ny, nx))
    return visited[n-1][m-1]
