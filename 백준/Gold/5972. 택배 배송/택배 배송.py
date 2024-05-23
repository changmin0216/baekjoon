import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())

map_ = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    map_[a].append([b, c])
    map_[b].append([a, c])

distance = [INF] * (n+1)
q = []
heapq.heappush(q, (0, 1))
distance[1] = 0

while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
        continue

    for i in map_[now]:
        if distance[i[0]] > distance[now] + i[1]:
            distance[i[0]] = distance[now] + i[1]
            heapq.heappush(q, (distance[now] + i[1], i[0]))
print(distance[n])