import sys
input = sys.stdin.readline

dp = [[0 for _ in range(15)] for _ in range(15)]

for i in range(15):
    dp[0][i] = i

for i in range(1, 15):
    for j in range(1, 15):
        if j == 1:
            dp[i][j] = 1
        else:
            dp[i][j] = dp[i][j-1] + dp[i-1][j]
t = int(input())

for _ in range(t):
    k = int(input()) # k층
    n = int(input()) # n호

    print(dp[k][n])

