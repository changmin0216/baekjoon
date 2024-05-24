import sys
from collections import deque
input = sys.stdin.readline

n, m, v = map(int, input().split())

map_ = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    map_[a].append(b)
    map_[b].append(a)


q = deque()

for i in range(len(map_)):
    map_[i].sort()

visited = [False] * (n+1)
def dfs(start):
    for v in map_[start]:
        if not visited[v]:
            print(v, end=' ')
            visited[v] = True
            dfs(v)
    return

print(v, end=' ')
visited[v] = True
dfs(v)
print()
visited = [False] * (n+1)
def bfs(start):
    print(start, end=' ')
    visited[start] = True
    q.append(start)

    while q:
        a = q.popleft()
        for v in map_[a]:
            if not visited[v]:
                print(v, end=' ')
                visited[v] = True
                q.append(v)
    return

bfs(v)
