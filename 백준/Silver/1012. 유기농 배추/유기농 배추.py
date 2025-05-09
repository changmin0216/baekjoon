import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dfs(y, x):
    visited[y][x] = True

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0<=ny<n and 0<=nx<m and graph[ny][nx] == 1 and not visited[ny][nx]:
            dfs(ny, nx)
    return

#############################
t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())

    graph = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    visited = [[False] * m for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and not visited[i][j]:
                dfs(i, j)
                cnt+=1

    print(cnt)