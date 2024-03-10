import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

maps = [[999] for _ in range(N+1)]
for i in range(1, N+1):
    for v in map(int, input().strip()):
        maps[i].append(v)

dx = [0,0,-1,1]
dy = [-1,1,0,0]
def bfs(y, x):
    global maps
    q = deque()
    q.append((y, x))
    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0 < ny <= N and 0 < nx <= M and maps[ny][nx] == 1:
                    q.append((ny, nx))
                    maps[ny][nx] = maps[ey][ex] + 1
bfs(1,1)
print(maps[N][M])