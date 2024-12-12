import sys
input = sys.stdin.readline

n = int(input())

dp = [0]*(n+1)

if n%2==0:
    print('CY')
else:
    print('SK')
# dp[1] = 상근
# dp[2] = 창영
# dp[3] = 상근
# dp[4] = 창영
# dp[5] = 상근
# dp[6] =