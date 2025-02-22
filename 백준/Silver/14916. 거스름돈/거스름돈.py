import sys
input = sys.stdin.readline

n = int(input())

if n <= 3:
    if n==2:
        print(1)
    else:
        print(-1)
    exit(0)
if n <=5:
    if n==4:
        print(2)
    else:
        print(1)
    exit(0)

dp = [-1]*(n+1)
dp[2] = 1
dp[3] = -1
dp[4] = 2
dp[5] = 1

for i in range(6, n+1):
    if dp[i-2]!=-1 and dp[i-5]!=-1:
        dp[i] = min(dp[i-2]+1, dp[i-5]+1)
    
    elif dp[i-2]==-1 and dp[i-5]==-1:
        dp[i] = -1
    
    elif dp[i-2] == -1:
        dp[i] = dp[i-5]+1
    else:
        dp[i] = dp[i-2]+1
print(dp[n])