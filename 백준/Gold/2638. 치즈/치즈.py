import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())

g = []
for _ in range(n):
    g.append(list(map(int, input().split())))

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs():
    visited = [[False]*m for _ in range(n)]
    q = deque()
    q.append((0,0))
    visited[0][0] = True
    chz = defaultdict(int)
    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i],

            if 0<=ny<n and 0<=nx<m and not visited[ny][nx]:

                if g[ny][nx] == 0:
                    visited[ny][nx] = True
                    q.append((ny, nx))
                else:
                    chz[(ny, nx)]+=1


    del_chz = []
    for i in chz:
        if chz[i] >= 2:
            del_chz.append(i)

    if del_chz:
        for y, x in del_chz:
            g[y][x] = 0
        return False
    else:
        return True

time_ = 0
while True:

    ret = bfs()
    if ret:
        break
    time_+=1
print(time_)