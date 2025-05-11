import sys
input = sys.stdin.readline

# 상하좌우
dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dfs(y, x):
    stack.append((y, x))
    visited[y][x] = True

    while stack:
        ey, ex = stack.pop()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0<=ny<n and 0<=nx<n:
                if not visited[ny][nx] and graph[ny][nx] == graph[y][x]:
                    stack.append((ny, nx))
                    visited[ny][nx] = True

    return

def dfs_blindness(y, x):
    stack.append((y, x))
    visited[y][x] = True

    while stack:
        ey, ex = stack.pop()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if not visited[ny][nx]:
                    if graph[ny][nx] == graph[y][x] or (graph[y][x] == 'R' and graph[ny][nx] == 'G') or (graph[y][x] == 'G' and graph[ny][nx] == 'R'):
                        stack.append((ny, nx))
                        visited[ny][nx] = True

    return
###########################
n = int(input())

graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))

stack = []

visited = [[False]*n for _ in range(n)]

result = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            result+=1

print(result, end=' ')

result_blindness = 0
visited = [[False]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs_blindness(i, j)
            result_blindness+=1

print(result_blindness)