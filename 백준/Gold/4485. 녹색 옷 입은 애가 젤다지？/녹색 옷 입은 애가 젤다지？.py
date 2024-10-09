import sys
from collections import deque
import heapq
INF = int(1e9)
input = sys.stdin.readline

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def bfs(g, n):
    y, x = 0,0
    distance = [[INF]*n for _ in range(n)]
    distance[y][x] = g[y][x]

    q = []
    heapq.heappush(q, (g[0][0], (y, x)))

    # q = deque()
    # q.append((y, x))

    while q:
        dist, now = heapq.heappop(q)

        if distance[now[0]][now[1]] < dist:
            continue
        for i in range(4):
            ny, nx = now[0] + dy[i], now[1] + dx[i]

            if 0<=ny<n and 0<=nx<n:
                if distance[ny][nx] > g[ny][nx] + distance[now[0]][now[1]]:
                    distance[ny][nx] = g[ny][nx] + distance[now[0]][now[1]]
                    heapq.heappush(q, (dist, (ny, nx),))
    return distance[n-1][n-1]

cnt = 1
while True:
    n = int(input())
    if n==0:
        break

    g = []
    for _ in range(n):
        g.append(list(map(int, input().split())))

    print("Problem",cnt, end='')
    print(":", bfs(g, n))
    cnt+=1