import sys
input = sys.stdin.readline

t, w = map(int, input().split())

arr = [0]
dp = [[0]*(w+1) for _ in range(t+1)]

for _ in range(t):
    arr.append(int(input()))

dp[1][0], dp[1][1] = arr[1] % 2, arr[1] // 2

for i in range(2, t+1):
    for j in range(w+1):
        if j%2==0:
            k = arr[i] % 2
        else:
            k = arr[i] // 2
        dp[i][j] = max(dp[i-1][0:j+1])+k
print(max(dp[-1]))