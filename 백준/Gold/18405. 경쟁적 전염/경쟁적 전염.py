import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())

examiner = []

for _ in range(n):
    examiner.append(list(map(int, input().split())))

s, x, y = map(int, input().split())

tmp = []

for i in range(n):
    for j in range(n):
        if examiner[i][j]!=0:
            tmp.append([i,j,examiner[i][j], 0])
tmp.sort(key=lambda x:x[2])

q = deque()

for v in tmp:
    q.append(v)

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
while q:
    ey, ex, ek, time = q.popleft()

    if time == s:
        break

    for i in range(4):
        ny, nx = ey + dy[i], ex + dx[i],

        if 0<=ny<n and 0<=nx<n:
            if examiner[ny][nx] == 0:
                examiner[ny][nx] = ek
                q.append([ny, nx, ek, time+1])

print(examiner[x-1][y-1])