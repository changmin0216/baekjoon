import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split())

g = [[] for _ in range(n+1)]
degree = [0 for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)

    degree[b]+=1

q = []
for i in range(1, n+1):
    if degree[i] == 0:
        heapq.heappush(q, i)

answer = []
while q:
    x = heapq.heappop(q)
    answer.append(x)
    for i in g[x]:
        degree[i]-=1
        if degree[i] == 0:
            heapq.heappush(q, i)
print(*answer)