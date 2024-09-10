import sys
from copy import deepcopy
from collections import deque
from itertools import combinations
input = sys.stdin.readline
INF = int(1e9)

dx = [0,0,-1,1]
dy = [-1,1,0,0]
def bfs():
    q = deque()
    q.append((0,0,0))

    while q:
        dist, ey, ex = q.popleft()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0<=ny<n and 0<=nx<n:
                cost = dist
                if room[ny][nx] == 0:
                    cost+=1
                if cost < distance[ny][nx]:
                    distance[ny][nx] = cost
                    q.append((cost, ny, nx))


n = int(input())

room = []

for i in range(n):
    room.append(list(map(int, input().rstrip())))

distance = [[INF] * n for _ in range(n)]

bfs()
print(distance[n-1][n-1])