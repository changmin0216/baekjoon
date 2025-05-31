import sys
input = sys.stdin.readline
from collections import deque

def dfs(y, x):
    global flag
    if flag:
        return

    if abs(y - ey) + abs(x - ex) <= 1000:
        print("happy")
        flag = True
        return

    for i in range(n):
        if not visited[i]:
            ny, nx = con_store[i]
            if abs(ny - y) + abs(nx - x) <= 1000:
                visited[i] = True
                dfs(ny, nx)
    return

def bfs():
    q = deque()
    q.append((sy, sx))

    while q:
        y, x = q.popleft()
        if abs(y - ey) + abs(x - ex) <= 1000: ##맥주 20개 안으로 갈 수 있으면
            print("happy")
            return

        for i in range(n):
            if not visited[i]:
                ny, nx = con_store[i]
                if abs(ny - y) + abs(nx - x) <= 1000: ##아직 맥주 먹기 전이라면
                    q.append((ny, nx))
                    visited[i] = True

    print("sad")
    return

############################
t = int(input())

for _ in range(t):
    n = int(input())
    sy, sx = map(int, input().split())

    con_store = []
    for _ in range(n):
        con_store.append(list(map(int, input().split())))

    ey, ex = map(int, input().split())

    visited = [False] * n
    # bfs()
    flag = False
    dfs(sy, sx)
    if not flag:
        print("sad")