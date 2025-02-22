import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs(y, x):
    result = -1
    q = deque()
    q.append((y, x, 0))

    visited = [[False] * m for _ in range(n)]
    visited[y][x] = True

    while q:
        ey, ex, dist = q.popleft()

        result = max(result, dist)
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx]:
                if map_[ny][nx] == 'L':
                    visited[ny][nx] = True
                    q.append((ny, nx, dist+1))
    return result
n, m = map(int, input().split())

map_ = []
for _ in range(n):
    map_.append(input().rstrip())

result = -1
for i in range(n):
    for j in range(m):
        if map_[i][j] == 'L':
            result = max(result, bfs(i, j))

print(result)