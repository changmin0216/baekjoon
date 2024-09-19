import sys
from collections import deque
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
graph = []

now_y, now_x = 0,0
size = 2 # 현재 상어 크기
for i in range(n):
    t = list(map(int, input().split()))
    for j in range(n):
        if t[j] == 9:
            now_y, now_x = i, j
            t[j] = 0
    graph.append(t)

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs():
    # 값이 -1이라면 도달할 수 없다는 의미(초기화)
    dist = [[-1]*n for _ in range(n)]
    # 시작 위치는 도달이 가능하다고 보며 거리는 0
    q = deque([(now_y, now_x)])
    dist[now_y][now_x] = 0

    while q:
        ey, ex = q.popleft()
        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<n and 0<=nx<n:
                if dist[ny][nx] == -1 and graph[ny][nx] <= size:
                    dist[ny][nx] = dist[ey][ex] + 1
                    q.append((ny, nx))
    return dist

def find(dist):
    y, x = 0, 0
    min_dist = INF
    for i in range(n):
        for j in range(n):
            # 도달이 가능하면서 먹을 수 있는 물고기일 때
            if dist[i][j]!=-1 and 1<=graph[i][j] and graph[i][j]<size:
                # 가장 가까운 물고기 1마리만 선택
                if dist[i][j] < min_dist:
                    y, x = i, j
                    min_dist = dist[i][j]
    if min_dist == INF:
        return None
    else:
        return y, x, min_dist

result = 0
ate = 0

while True:
    value = find(bfs())
    if value is None:
        print(result)
        break
    else:
        now_y, now_x = value[0], value[1],
        result+=value[2]
        graph[now_y][now_x] = 0
        ate+=1
        if ate>=size:
            size+=1
            ate=0