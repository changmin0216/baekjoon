import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    if n<=2:
        print(n)
    else:
        dp = [0] * (n+1)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for i in range(4,n+1):
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

        print(dp[n])
