n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input())))

visited = [[False]*n for _ in range(n)]
dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dfs(y, x):
    global cnt
    cnt+=1
    visited[y][x] = True

    for i in range(4):
        ny, nx = y+dy[i], x+dx[i],

        if 0<=ny<n and 0<=nx<n:
            if graph[ny][nx]!=0 and not visited[ny][nx]:
                dfs(ny, nx)

result = []
for i in range(n):
    for j in range(n):
        if graph[i][j]==1 and not visited[i][j]:
            cnt = 0
            dfs(i, j)
            result.append(cnt)
result.sort()
print(len(result))
for i in result:
    print(i)