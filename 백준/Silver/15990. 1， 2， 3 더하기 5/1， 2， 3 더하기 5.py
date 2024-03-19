import sys
input = sys.stdin.readline

t = int(input())

dp = list([0,0,0] for _ in range(100001))

dp[1] = [1, 0, 0]
dp[2] = [0, 1, 0]
dp[3] = [1, 1, 1]

for i in range(4, 100001):
    dp[i][0] = (dp[i-1][1] + dp[i-1][2])%1000000009  #1로 끝나려면 1을 더해야 하니까 i-1번째에서 2로 끝나는거랑 3으로 끝나는거
    dp[i][1] = (dp[i-2][0] + dp[i-2][2])%1000000009
    dp[i][2] = (dp[i-3][0] + dp[i-3][1])%1000000009

for _ in range(t):
    print(sum(dp[int(input())])%1000000009)
