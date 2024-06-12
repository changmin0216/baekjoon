import copy
import sys
from itertools import combinations
from collections import deque
input = sys.stdin.readline

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
def bfs(graph):
    tmp = copy.deepcopy(graph)
    q = deque()

    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 2:
                    q.append([i, j])

    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]
            if 0 <= ny < n and 0 <= nx < m:
                if tmp[ny][nx] == 0:
                    tmp[ny][nx] = 2
                    q.append([ny, nx])
    cnt = 0
    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 0:
                cnt += 1
    return cnt

n, m = map(int, input().split()) # 세로, 가로

laboratory = []

candidate = []
for i in range(n):
    l = list(map(int, input().split()))

    for j in range(len(l)):
        if l[j] == 0:
            candidate.append([i, j])

    laboratory.append(l)

result = []
for v in combinations(candidate, 3):
    temp = []
    for q in v:
        temp.append([q[0], q[1]])
        laboratory[q[0]][q[1]] = 1
    cnt = bfs(laboratory)
    result.append(cnt)
    for s in temp:
        laboratory[s[0]][s[1]] = 0

print(max(result))