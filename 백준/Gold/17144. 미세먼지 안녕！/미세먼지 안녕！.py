import sys
from collections import deque
input = sys.stdin.readline


dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dust_diffusion():

    q = deque()

    for i in range(r):
        for j in range(c):
            if map_[i][j]!=0 and map_[i][j]!=-1:
                q.append((i, j, map_[i][j]))

    while q:
        ey, ex, value = q.popleft()

        plus = value//5
        cnt = 0
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<r and 0<=nx<c and map_[ny][nx]!=-1:
                map_[ny][nx]+=plus
                cnt+=1
        map_[ey][ex]-=(plus*cnt)

# 공기청정기 위쪽 이동
def air_up():
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = up, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == up and y == 0:
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            direct += 1
            continue
        map_[x][y], before = before, map_[x][y]
        x = nx
        y = ny

# 공기청정기 아래쪽 이동
def air_down():
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = down, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == down and y == 0:
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            direct += 1
            continue
        map_[x][y], before = before, map_[x][y]
        x = nx
        y = ny

r, c, t = map(int, input().split())

map_ = []
air_pos = []
for i in range(r):
    tmp = list(map(int, input().split()))
    map_.append(tmp)

up = -1
down = -1
# 공기 청정기 위치 찾기
for i in range(r):
    if map_[i][0] == -1:
        up = i
        down = i + 1
        break

for _ in range(t):
    dust_diffusion() ##미세 먼지 확산
    air_up()
    air_down()

result = 0
for i in range(r):
    for j in range(c):
        if map_[i][j] != -1:
            result+=map_[i][j]
print(result)