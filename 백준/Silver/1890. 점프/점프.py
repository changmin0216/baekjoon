import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

dp = [[-1] * n for _ in range(n)]
def dfs(y, x):
    if y == n-1 and x == n-1:
        return 1
    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0
    for dy, dx in ((1, 0), (0, 1)):
        ny, nx = y + dy*graph[y][x], x + dx*graph[y][x]
        if 0<=ny<n and 0<=nx<n:
            dp[y][x]+=dfs(ny, nx)
    return dp[y][x]
print(dfs(0, 0))