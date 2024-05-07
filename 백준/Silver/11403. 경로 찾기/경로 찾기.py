import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())

d = [[INF for _ in range(n)] for _ in range(n)]

for i in range(n):
    l = list(map(int, input().split()))
    for j in range(len(l)):
        if l[j] == 1:
            d[i][j] = 1

for k in range(n):
    for a in range(n):
        for b in range(n):
            d[a][b] = min(d[a][k]+d[k][b], d[a][b])

for i in range(n):
    for j in range(n):
        if d[i][j]==INF:
            print(0, end=' ')
        else:
            print(1, end=' ')
    print()
