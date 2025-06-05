import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)

for _ in range(m):
    x, y, k = map(int, input().split())
    indegree[x]+=1
    graph[y].append((x, k))

dp = [[0] * (n+1) for _ in range(n+1)]

result = [0] * (n+1)
def toplogy_sort():
    q = deque()

    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)
            dp[i][i] = 1

    while q:
        now = q.popleft()

        for next, cnt in graph[now]:
            for i in range(1, n+1):
                dp[next][i] += dp[now][i] * cnt
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

toplogy_sort()

for i in range(1, n+1):
    if dp[n][i] > 0:
        print(i, dp[n][i])