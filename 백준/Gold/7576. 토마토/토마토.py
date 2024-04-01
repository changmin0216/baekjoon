import sys
input = sys.stdin.readline
from collections import deque
m, n = map(int, input().split())

maps = []

for _ in range(n):
    maps.append(list(map(int, input().split())))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
def bfs(tomato):
    global day
    q = deque(tomato)

    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0<=ny<n and 0<=nx<m:
                if maps[ny][nx] == 0:
                    maps[ny][nx] = maps[ey][ex]+1
                    q.append((ny, nx))

tomato = []
for i in range(n):
    for j in range(m):
        if maps[i][j] == 1:
            tomato.append((i,j))

bfs(tomato)

result = 0
for i in range(n):
    for j in range(m):
        if maps[i][j] == 0:
            print(-1)
            exit()
        result = max(result, maps[i][j])
print(result-1)

