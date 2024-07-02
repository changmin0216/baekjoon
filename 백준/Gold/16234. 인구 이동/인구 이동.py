import sys
from collections import deque
input = sys.stdin.readline

n, l, r = map(int, input().split())

ground = []

for _ in range(n):
    ground.append(list(map(int, input().split())))

visited = [[False for _ in range(n)] for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def process(y, x, index):
    q = deque()
    q.append([y, x])
    union[y][x] = index
    cnt = 1
    total = ground[y][x]

    tmp = [[y, x]]

    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny = ey + dy[i]
            nx = ex + dx[i]

            if 0<=ny<n and 0<=nx<n and union[ny][nx]==-1:
                if l <= abs(ground[ny][nx] - ground[ey][ex]) <= r:
                    q.append([ny, nx])
                    union[ny][nx] = index
                    cnt+=1
                    total+=ground[ny][nx]
                    tmp.append([ny, nx])

    for v in tmp:
        ground[v[0]][v[1]] = total//cnt
        
    return cnt

total_count = 0

while True:
    union = [[-1]*n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j]==-1:
                process(i,j,index)
                index+=1
    if index == n*n:
        break
    total_count+=1

print(total_count)