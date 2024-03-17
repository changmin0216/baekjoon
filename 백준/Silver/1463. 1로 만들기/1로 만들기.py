import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * (n + 1)
dp[1] = 0
if 1<n<=3:
    for i in range(1, n+1):
        dp[i] = 1
elif n>3:
    dp[2]=1
    dp[3]=1
    for i in range(4, n+1):
        if i%6==0:
            dp[i] = min(dp[i-1]+1, dp[i//2] + 1, dp[i//3]+1)
            continue
        elif i%3==0:
            dp[i] = min(dp[i - 1] + 1, dp[i // 3] + 1)
            continue
        elif i%2==0:
            dp[i] = min(dp[i - 1] + 1, dp[i // 2] + 1)
            continue
        else:
            dp[i] = dp[i - 1] + 1
print(dp[n])