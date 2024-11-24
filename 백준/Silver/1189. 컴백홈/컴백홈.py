import sys
from collections import deque
input = sys.stdin.readline

r, c, k = map(int, input().split())

graph = []
for _ in range(r):
    graph.append(list(input().rstrip()))

dy = [-1,1,0,0]
dx = [0,0,-1,1]

visited = [[False] * c for _ in range(r)]
answer = 0
def dfs(y, x, dist):
    global answer
    if y==0 and x==c-1 and dist==k:
        answer+=1
        return

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0<=ny<r and 0<=nx<c and graph[ny][nx] == '.':
            if not visited[ny][nx]:
                visited[ny][nx] = True
                dfs(ny, nx, dist+1)
                visited[ny][nx] = False

visited[r-1][0] = True
dfs(r-1, 0, 1)
print(answer)