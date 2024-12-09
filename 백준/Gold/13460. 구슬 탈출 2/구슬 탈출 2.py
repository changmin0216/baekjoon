import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(input()))
    for j in range(m):
        if graph[i][j] == 'R':
            ry, rx = i, j
        elif graph[i][j] == 'B':
            by, bx = i, j

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
def bfs(ry, rx, by, bx):
    q = deque()
    q.append((ry, rx, by, bx))
    visited = []
    visited.append((ry, rx, by, bx))
    count = 0
    while q:
        for _ in range(len(q)):
            ry, rx, by, bx = q.popleft()
            if count > 10:
                print(-1)
                return
            if graph[ry][rx] == 'O':
                print(count)
                return
            for i in range(4):
                nry, nrx = ry, rx
                while True:
                    nry += dy[i]
                    nrx += dx[i]
                    if graph[nry][nrx] == '#':
                        nry -= dy[i]
                        nrx -= dx[i]
                        break
                    if graph[nry][nrx] == 'O':
                        break
                nby, nbx = by, bx
                while True:  # #일 때까지 혹은 구멍일 때까지 움직임
                    nby += dy[i]
                    nbx += dx[i]
                    if graph[nby][nbx] == '#':
                        nby -= dy[i]
                        nbx -= dx[i]
                        break
                    if graph[nby][nbx] == 'O':
                        break
                if graph[nby][nbx] == 'O':
                    continue
                if nry == nby and nrx == nbx:
                    if abs(nry - ry) + abs(nrx - rx) > abs(nby - by) + abs(
                            nbx - bx):
                        nry -= dy[i]
                        nrx -= dx[i]
                    else:
                        nby -= dy[i]
                        nbx -= dx[i]
                if (nry, nrx, nby, nbx) not in visited:
                    q.append((nry, nrx, nby, nbx))
                    visited.append((nry, nrx, nby, nbx))
        count += 1
    print(-1)
bfs(ry, rx, by, bx)
