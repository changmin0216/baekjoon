import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())

friend = [[] for _ in range(n+1)]

distance = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    distance[i][i] = 0

while True:
    a, b = map(int, input().split())
    if a==-1 and b==-1:
        break

    distance[a][b] = 1
    distance[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if distance[i][j] > distance[i][k] + distance[k][j]:
                distance[i][j] = distance[i][k] + distance[k][j]

result = []
for i in range(1, n+1):
    max_num = -1
    for j in range(1, n+1):
        if distance[i][j]!=0 and distance[i][j]!=INF:
            max_num = max(max_num, distance[i][j])
    result.append(max_num)

president_num = min(result)

cnt = 0
r = []
for i in range(len(result)):
    if result[i]==president_num:
        cnt+=1
        r.append(i+1)

print(president_num, cnt)
print(' '.join(map(str, r)))