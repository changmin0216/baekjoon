import sys
input = sys.stdin.readline
INF = int(1e9)

def bf():
    distance = [INF] * (n+1)

    for i in range(n):
        for j in range(len(g)):
            cur = g[j][0]
            next_node = g[j][1]
            cost = g[j][2]
            if distance[next_node] > distance[cur] + cost:
                distance[next_node] = distance[cur] + cost
                if i==n-1:
                    return True

    return False

t = int(input())

for _ in range(t):
    n, m, w = map(int, input().split())
    g = []

    for _ in range(m):
        a, b, c = map(int, input().split())
        g.append((a, b, c))
        g.append((b, a, c))

    for _ in range(w):
        a, b, c = map(int, input().split())
        g.append((a, b, -c))

    if bf():
        print("YES")
    else:
        print("NO")