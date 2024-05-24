import sys
from collections import deque
input = sys.stdin.readline

## 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

visited = [False] * (n+1)


def bfs(start):
    result = []

    q = deque()
    q.append((start, 0))
    visited[start] = True

    while q:
        next, cost = q.popleft()
        if cost == k:
            result.append(next)

        for v in graph[next]:
            if not visited[v]:
                visited[v] = True
                q.append((v, cost+1))
    return result

result = bfs(x)
result.sort()

if len(result) != 0:
    for v in result:
        print(v)
else:
    print(-1)