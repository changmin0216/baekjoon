import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

arr = []
start_y, start_x = 0, 0
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        if row[j]==2:
            start_y, start_x = i, j
    arr.append(row)

visited = [[-1] * m for _ in range(n)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]

def bfs(y, x):
    visited[y][x] = 0
    q = deque()
    q.append((start_y, start_x))

    while q:
        ey, ex = q.popleft()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i],

            if 0<=ny<n and 0<=nx<m:
                if arr[ny][nx]==1: # 방문 가능한 곳
                    if visited[ny][nx]==-1: # 아직 방문X
                        visited[ny][nx]=visited[ey][ex]+1
                        q.append((ny, nx))
bfs(start_y, start_x)

for i in range(n):
    for j in range(m):
        if visited[i][j] == -1 and arr[i][j]==0:
            visited[i][j]=0

for i in visited:
    print(' '.join(map(str, i)))