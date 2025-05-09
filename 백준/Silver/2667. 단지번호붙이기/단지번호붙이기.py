import sys
input = sys.stdin.readline

dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dfs(y, x, cnt):
    visited[y][x] = True

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i],

        if 0<=ny<n and 0<=nx<n and graph[ny][nx] == 1:
            if not visited[ny][nx]:
                cnt = dfs(ny, nx, cnt+1)
    return cnt

## 5<=n<=25
n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

visited = [[False] * n for _ in range(n)]

num = 0
result = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            cnt = dfs(i, j, 1)
            num+=1
            result.append(cnt)
result.sort()

print(num)
for i in result:
    print(i)