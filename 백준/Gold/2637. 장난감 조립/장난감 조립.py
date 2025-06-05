import sys
from collections import deque
input = sys.stdin.readline

n = int(input())  # 총 부품 수
m = int(input())  # 부품 관계 수

graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)

for _ in range(m):
    x, y, k = map(int, input().split())  # y를 k개 사용해서 x를 만든다
    graph[y].append((x, k))
    indegree[x] += 1

# dp[x][i] = x를 만들기 위해 필요한 기본 부품 i의 개수
dp = [[0] * (n+1) for _ in range(n+1)]

q = deque()

# 기본 부품부터 시작 (진입 차수 0)
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)
        dp[i][i] = 1  # 자기 자신이 필요한 부품

while q:
    now = q.popleft()
    for nxt, cnt in graph[now]:
        for i in range(1, n+1):
            dp[nxt][i] += dp[now][i] * cnt  # 하위 부품의 기본 부품 개수 누적
        indegree[nxt] -= 1
        if indegree[nxt] == 0:
            q.append(nxt)

# 최종 부품(n)을 만들기 위해 필요한 기본 부품 출력
for i in range(1, n+1):
    if dp[n][i] > 0:
        print(i, dp[n][i])
