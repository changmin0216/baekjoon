import sys
input = sys.stdin.readline
import heapq
INF = int(1e9)

n = int(input())
m = int(input())

g = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    g[a].append([b, c])
s, e = map(int, input().split())

distance = [INF] * (n + 1)
previous = [-1] * (n + 1)
def dijkstra(start):
    distance[start] = 0

    q = []
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in g[now]:
            cost = i[1] + dist
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                previous[i[0]] = now  # 이전 노드를 기록
                heapq.heappush(q, (cost, i[0]))
def get_path(end):
    path = []
    while end != -1:
        path.append(end)
        end = previous[end]
    path.reverse()
    return path

dijkstra(s)
print(distance[e])

p = get_path(e)
print(len(p))
print(' '.join(map(str, p)))