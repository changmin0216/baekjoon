import sys
input = sys.stdin.readline
INF = int(1e9)

def bf():
    global distance
    for i in range(n):
        for j in range(len(g)):
            cur = g[j][0]
            next_node = g[j][1]
            cost = g[j][2]

            if distance[cur] == INF:
                continue
            if distance[next_node] > distance[cur] + cost:
                distance[next_node] = distance[cur] + cost
                if i==n-1:
                    return True

    return False

n, m = map(int, input().split())

g = []
for _ in range(m):
    a, b, c = map(int, input().split())
    g.append([a,b,c])

distance = [INF] * (n+1)
distance[1] = 0

if bf():
    print(-1)
else:
    for i in range(2, n+1):
        if distance[i] == INF:
            print(-1)
        else:
            print(distance[i])