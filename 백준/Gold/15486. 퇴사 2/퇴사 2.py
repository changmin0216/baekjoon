import sys
input = sys.stdin.readline

n = int(input())

cost = []
date = []

for _ in range(n):
    a, b = map(int, input().split())
    date.append(a)
    cost.append(b)

dp = [0]*(n+1)

# 마지막 날부터 거꾸로 계산
for i in range(n - 1, -1, -1):
    if i + date[i] <= n:  # 현재 일을 수락할 수 있는 경우
        dp[i] = max(cost[i] + dp[i + date[i]], dp[i + 1])
    else:  # 일을 수락할 수 없는 경우, 다음 날의 최대 이익을 그대로 가져옴
        dp[i] = dp[i + 1]
print(dp[0])



