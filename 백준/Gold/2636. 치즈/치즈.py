import sys
from collections import deque
input = sys.stdin.readline

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs():
    q = deque()
    q.append((0,0))
    visited = [[False] * m for _ in range(n)]

    chz = []
    while q:
        ey, ex = q.popleft()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx]:
                visited[ny][nx] = True

                if g[ny][nx] == 0:
                    q.append((ny, nx))
                else:
                    chz.append((ny, nx))

    if chz:
        for i in chz:
            g[i[0]][i[1]] = 0
        return len(chz)
    else:
        return False

# n,m <= 100
n, m = map(int, input().split())

g = []
for i in range(n):
    tmp = list(map(int, input().split()))
    g.append(tmp)

time = 0
cnt = 0
while True:
    r = bfs()
    if r:
        time+=1
        cnt = r
    else:
        break
print(time)
print(cnt)