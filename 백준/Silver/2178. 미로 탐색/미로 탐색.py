from collections import deque

n, m = map(int, input().split())
graph = []

for i in range(n):
    graph.append(list(map(int, input())))

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs():
    q = deque()
    q.append((0, 0, 1))

    visited = [[False]*m for _ in range(n)]
    visited[0][0] = True

    while q:
        ey, ex, dist = q.popleft()

        if ey==n-1 and ex==m-1:
            print(dist)
            return
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<n and 0<=nx<m:
                if graph[ny][nx]!=0 and not visited[ny][nx]:
                    q.append((ny, nx, dist+1))
                    visited[ny][nx] = True

bfs()