#와인을 안 먹는 경우
#와인을 먹는 경우

import sys
input = sys.stdin.readline

n = int(input())
wine_list = list(int(input()) for _ in range(n))

dp = [0] * n

dp[0] = wine_list[0]
if n>1:
    dp[1] = wine_list[0] + wine_list[1]
if n>2:
    dp[2] = max(dp[1], wine_list[2]+wine_list[1], wine_list[0] + wine_list[2])

for i in range(3, n):
    dp[i] = max(dp[i-1], wine_list[i] + dp[i-2], wine_list[i]+wine_list[i-1]+dp[i-3])

print(max(dp))

