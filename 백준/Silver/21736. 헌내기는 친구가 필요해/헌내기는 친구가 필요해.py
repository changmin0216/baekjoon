import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

g = []

start_y, start_x = 0, 0
for i in range(n):
    tmp = list(input().rstrip())
    for j in range(m):
        if tmp[j] == 'I':
            start_y, start_x = i, j
    g.append(tmp)

visited = [[False]*m for _ in range(n)]
dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs(y, x):
    cnt = 0
    q = deque()
    q.append((y, x))
    visited[y][x] = True

    while q:
        ey, ex = q.popleft()

        if g[ey][ex] == 'P':
            cnt+=1
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<n and 0<=nx<m and not visited[ny][nx] and g[ny][nx]!='X':
                visited[ny][nx] = True
                q.append((ny, nx))
    return cnt

meet_p = bfs(start_y, start_x)

if meet_p == 0:
    print('TT')
else:
    print(meet_p)
