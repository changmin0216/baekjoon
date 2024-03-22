import sys
input = sys.stdin.readline

n = int(input())
ary = list(map(int, input().split()))

dp = ary

for i in range(1, n):
    if dp[i-1] + dp[i] > dp[i]:
        dp[i] = dp[i-1] + dp[i]

print(max(dp))