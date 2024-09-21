import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())

    card = []
    for _ in range(2):
        card.append(list(map(int, input().split())))

    dp = [[0]*n for _ in range(2)]

    dp[0][0] = card[0][0]
    dp[1][0] = card[1][0]
    if n>=2:
        dp[0][1] = card[0][1] + dp[1][0]
        dp[1][1] = card[1][1] + dp[0][0]

        for i in range(2, n):
            for j in range(2):
                if j==0:
                    dp[j][i] = card[j][i] + max(dp[j+1][i-2], dp[j-1][i-1])
                else:
                    dp[j][i] = card[j][i] +  max(dp[j-1][i-1], dp[j-1][i-2])

    print(max(dp[0][n-1], dp[1][n-1]))
