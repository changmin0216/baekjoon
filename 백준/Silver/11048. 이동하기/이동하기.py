import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

dy = [1,0]
dx = [0,1]

def bfs():
    q = deque()
    q.append((0,0))

    visited = [[-1]*m for _ in range(n)]
    visited[0][0] = graph[0][0]

    while q:
        ey, ex = q.popleft()

        for i in range(2):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<n and 0<=nx<m:
                if visited[ny][nx] < visited[ey][ex] + graph[ny][nx]:
                    visited[ny][nx] = visited[ey][ex] + graph[ny][nx]
                    q.append((ny, nx))
    print(visited[n-1][m-1])

bfs()