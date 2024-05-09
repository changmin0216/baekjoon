import sys
input = sys.stdin.readline
import heapq
INF = int(1e9)

n, m, k, x = map(int, input().split())

distance = [INF for _ in range(n+1)]

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

def dijkstra(start):
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        dist, node = heapq.heappop(q)

        if distance[node] < dist:
            continue

        for i in graph[node]:
            if distance[i] > dist+1:
                distance[i] = dist+1
                heapq.heappush(q, (dist+1, i))

dijkstra(x)
flag = False
for i in range(len(distance)):
    if distance[i] == k:
        print(i)
        flag = True
if not flag:
    print(-1)

