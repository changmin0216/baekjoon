import sys
input = sys.stdin.readline
from collections import deque
n, m, v = map(int, input().split())

arr = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

for i in range(n+1):
    arr[i].sort()

visited_1 = [False]*(n+1)

result_1 = []
def dfs(k):
    if not visited_1[k]:
        visited_1[k] = True
        result_1.append(k)
    if len(result_1) == n:
        return
    for value in arr[k]:
        if not visited_1[value]:
            visited_1[value] = True
            result_1.append(value)
            dfs(value)
    return
dfs(v)
print(*result_1)


visited = [False]*(n+1)
result = []
queue = deque()
def bfs(k):
    if not visited[k]:
        queue.append(k)
    while queue:
        q = queue.popleft()
        if visited[q]:
            continue
        result.append(q)
        visited[q] = True
        if len(result) == n:
            return
        for value in arr[q]:
            if not visited[value]:
                queue.append(value)

bfs(v)
print(*result)