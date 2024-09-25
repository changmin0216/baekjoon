import sys
import copy
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
arr = []
ice = []

for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(len(temp)):
        if temp[j]!=0:
            ice.append((i,j))
    arr.append(temp)

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def melt(y, x):
    cnt = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0<=ny<n and 0<=nx<m:
            if arr[ny][nx]==0:
                cnt+=1
    return cnt

def bfs(y, x, num, crtt):
    if crtt[y][x]!=0:
        return

    crtt[y][x] = num
    q = deque()
    q.append((y, x))
    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i],
            if 0<=ny<n and 0<=nx<m and arr[ny][nx]!=0 and crtt[ny][nx]==0:
                crtt[ny][nx] = num
                q.append((ny, nx))
    return


year = 0
while True:
    year+=1
    tw = copy.deepcopy(ice)
    c = []
    for i in tw:
        c.append(melt(i[0], i[1]))

    for i in range(len(c)):
        if arr[tw[i][0]][tw[i][1]] <= c[i]:
            arr[tw[i][0]][tw[i][1]] = 0
            ice.remove((tw[i][0], tw[i][1]))
        else:
            arr[tw[i][0]][tw[i][1]]-=c[i]

    if not ice:
        print(0)
        exit(0)

    crtt = [[0]*m for _ in range(n)]
    for i in range(len(ice)):
        bfs(ice[i][0], ice[i][1], i+1, crtt)

    _max = -1
    for i in range(n):
        t = max(crtt[i])
        if t > _max:
            _max = t
    if _max >= 2:
        break
print(year)