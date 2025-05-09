import sys
from collections import deque
input = sys.stdin.readline

def dfs(node):
    if not visited[node]:
        print(node, end=' ')
        visited[node] = True
    for i in graph[node]:
        if not visited[i]:
            dfs(i)
    return

def bfs(start):
    print()
    q = deque()
    q.append(start)

    visited = [False] * (n+1)
    visited[start] = True

    while q:
        now = q.popleft()
        print(now, end=' ')
        for next in graph[now]:
            if not visited[next]:
                q.append(next)
                visited[next] = True
    return

n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

visited = [False] * (n+1)
dfs(v)
bfs(v)