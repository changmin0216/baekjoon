import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, cost = map(int, input().split())
    graph[a].append([b, cost])
    graph[b].append([a, cost])

v1, v2 = map(int, input().split())

def dijkstra(start):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance

origin = dijkstra(start=1)
v1_dist = dijkstra(v1)
v2_dist = dijkstra(v2)

v1_path = origin[v1] + v1_dist[v2] + v2_dist[n]
v2_path = origin[v2] + v2_dist[v1] + v1_dist[n]

result = min(v1_path, v2_path)

if result >= INF:
    print(-1)
else:
    print(result)