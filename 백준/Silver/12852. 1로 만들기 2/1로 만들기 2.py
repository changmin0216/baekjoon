import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * (n+1)

if n < 4:
    for i in range(2, n+1):
        dp[i] = 1
    print(dp[n])
else:
    dp[2] = 1
    dp[3] = 1
    for i in range(4, n+1):
        if i%6 == 0:
            dp[i] = min(dp[i-1], dp[i//2], dp[i//3]) + 1
        elif i%2 == 0:
            dp[i] = min(dp[i-1], dp[i//2]) + 1
        elif i%3 == 0:
            dp[i] = min(dp[i-1], dp[i//3]) + 1
        else:
            dp[i] = dp[i-1] + 1

    print(dp[n])


while n!=1:
    print(n, end=' ')
    if n % 6 == 0:
        min_value = min(dp[n - 1], dp[n // 2], dp[n // 3])
        if min_value == dp[n-1]:
            n-=1
        elif min_value == dp[n//3]:
            n//=3
        else:
            n//=2
    elif n % 2 == 0:
        min_value = min(dp[n - 1], dp[n // 2])
        if min_value == dp[n-1]:
            n-=1
        else:
            n//=2
    elif n % 3 == 0:
        min_value = min(dp[n - 1], dp[n // 3])
        if min_value == dp[n-1]:
            n-=1
        else:
            n//=3
    else:
        min_value = dp[n - 1] + 1
        n-=1
print(1)