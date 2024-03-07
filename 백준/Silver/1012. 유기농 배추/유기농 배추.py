import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(y, x):
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0<=ny<n and 0<=nx<m:
            if g[ny][nx]:
                g[ny][nx] = False
                dfs(ny, nx)
    return

t = int(input())
result=[]
for _ in range(t):
    m, n, k = map(int, input().split())
    g = [[False for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        x, y = map(int, input().split())
        g[y][x] = True

    cnt = 0
    for i in range(n):
        for j in range(m):
            if g[i][j]:
                dfs(i, j)
                cnt += 1
    result.append(cnt)

for r in result:
    print(r)