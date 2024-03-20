import sys
input = sys.stdin.readline

dp = [[0]*2 for _ in range(91)]

dp[1][1] = 1

dp[2][0] = 1

for i in range(3, 91):
    for j in range(2):
        if j == 0:
            dp[i][j] = dp[i-1][1] + dp[i-1][0]
        elif j == 1:
            dp[i][j] = dp[i-1][0]

n = int(input())
print(sum(dp[n]))
