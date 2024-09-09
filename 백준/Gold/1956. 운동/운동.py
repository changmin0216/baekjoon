import sys
input = sys.stdin.readline
INF = int(1e9)

v, e = map(int, input().split())

g = [[INF] * (v+1) for _ in range(v+1)]

for i in range(1, v+1):
    g[i][i] = 0

for _ in range(e):
    a, b, c = map(int, input().split())
    g[a][b] = c

for k in range(1, v+1):
    for a in range(1, v+1):
        for b in range(1, v+1):
            g[a][b] = min(g[a][b], g[a][k] + g[k][b])

result = int(1e7)
flag = False
for i in range(1, v+1):
    for j in range(1, v+1):
        # if g[i][j] != INF and g[i][j] != INF and i!=j::
        if i!=j:
            if g[i][j] + g[j][i] < result:
                result = g[i][j] + g[j][i]
if result == int(1e7):
    print(-1)
else:
    print(result)