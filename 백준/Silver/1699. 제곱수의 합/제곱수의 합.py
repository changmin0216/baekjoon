import sys, math
input = sys.stdin.readline

n = int(input())

dp = [x for x in range(n+1)]

for i in range(2, n + 1):
    for j in range(1, i + 1):
        if j**2 > i:
            break
        if dp[i] > dp[i - j**2] + 1:
            dp[i] = dp[i - j**2] + 1

print(dp[n])