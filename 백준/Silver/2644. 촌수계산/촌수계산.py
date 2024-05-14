import sys
input = sys.stdin.readline
from collections import deque

n = int(input())

graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

a, b = map(int, input().split())

m = int(input())

for i in range(m):
    x, y = map(int, input().split()) # 부모, 자식
    graph[x].append(y)
    graph[y].append(x)

q = deque()
q.append((a, 0))
visited[a] = True
while q:
    now, c = q.popleft()

    for v in graph[now]:
        if v == b:
            print(c+1)
            exit(0)
        if not visited[v]:
            q.append((v, c+1))
            visited[v] = True

print(-1)