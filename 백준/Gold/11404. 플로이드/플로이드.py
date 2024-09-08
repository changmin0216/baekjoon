import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input()) #도시의 개수
m = int(input()) #버스의 개수

result = [[INF]*(n+1) for _ in range(n+1)]

for i in range(0, n+1): 
    result[i][i]=0

for _ in range(m):
    a, b, c = map(int, input().split())
    result[a][b] = min(result[a][b], c)

for i in range(1, n+1):
    for j in range(1, n+1):
        for k in range(1, n+1):
            if(result[k][j] > result[k][i] + result[i][j]):
                result[k][j] = result[k][i] + result[i][j]
        
for i in range(1,n+1):
    # if (i!=1):
    #     print()
    for j in range(1, n+1):
        if result[i][j]==INF: print(0, end=' ' )
        else: print(result[i][j], end=' ')
    print()