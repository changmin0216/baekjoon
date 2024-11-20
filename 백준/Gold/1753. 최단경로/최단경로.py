import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

v, e = map(int, input().split())
start = int(input())

graph = [[] for _ in range(v+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])

    # if graph[a]:
    #     for i in range(len(graph[a])):
    #         if graph[a][i][0] == b:
    #             graph[a][i][0] = min(c, graph[a][i][1])
    #             break
    #     else: # break 안했으면
    #         graph[a].append([b, c])
    # else:
    #     graph[a].append([b, c])

def dijkstra(start):
    global distance
    distance[start] = 0

    q = []
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        # if distance[now] < dist:
        #     continue

        for i in graph[now]:
            cost = dist + i[1]
            next = i[0]
            if distance[next] > cost:
                distance[next] = cost
                heapq.heappush(q, (cost, next))

distance = [INF] * (v + 1)
dijkstra(start)

for i in range(1, v+1):
    if distance[i]!=INF:
        print(distance[i])
    else:
        print("INF")
