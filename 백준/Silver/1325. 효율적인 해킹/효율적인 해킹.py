import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

def bfs(start_node):
    visited = [False] * (n+1)
    q = deque()

    q.append(start_node)
    visited[start_node] = True

    cnt = 1
    while q:
        next = q.popleft()
        for i in graph[next]:
            if not visited[i]:
                cnt+=1
                visited[i] = True
                q.append(i)
    return cnt

max_ = -1
result = set()
for i in range(1, n+1):
    visited = [False] * (n + 1)
    length = bfs(i)
    if length > max_:
        max_ = length
        result.clear()
        result.add(i)
    elif length == max_:
        result.add(i)
print(*result)