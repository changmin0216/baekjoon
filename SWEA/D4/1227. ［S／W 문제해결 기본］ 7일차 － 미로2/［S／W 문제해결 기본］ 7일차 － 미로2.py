#import sys
from collections import deque
#input = sys.stdin.readline


def bfs(start_y, start_x, map_):

    q = deque()
    q.append((start_y, start_x))

    visited = [[False] * 100 for _ in range(100)]

    visited[start_y][start_x] = True

    while q:
        ey, ex = q.popleft()

        if map_[ey][ex] == 3:
            return True

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0 <=ny<100 and 0<=nx<100 and map_[ny][nx]!=1 and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx))
    return False

dy = [-1,1,0,0]
dx = [0,0,-1,1]

for _ in range(10):
    t = int(input())

    start_x, start_y = -1, -1
    map_ = []
    for i in range(100):
        tmp = list(map(int, input().rstrip()))
        for j in range(len(tmp)):
            if tmp[j] == 2:
                start_y = i
                start_x = j
        map_.append(tmp)

    print(f'#{t}', end=' ')
    if bfs(start_y, start_x, map_):
        print(1)
    else:
        print(0)