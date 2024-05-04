import sys
input = sys.stdin.readline


n, m = map(int, input().split())

graph = [[0 for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    short, tall = map(int ,input().split())
    graph[short][tall]=1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] == 1 or (graph[i][k] == 1 and graph[k][j] == 1):
                graph[i][j] = 1  # 자신보다 작은 경우

#출력
answer = 0
for i in range(1, n+1):
    known_height = 0
    for j in range(1, n+1):
        known_height += graph[i][j] + graph[j][i] #자신보다 작은사람과 큰사람의 합
    if known_height == n-1: #자신의 키 순서를 알 경우
        answer += 1
print(answer)