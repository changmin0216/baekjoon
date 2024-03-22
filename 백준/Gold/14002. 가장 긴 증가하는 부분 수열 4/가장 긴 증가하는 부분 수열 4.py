import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
dp = [[] for _ in range(n)]
for i in range(n):
    dp[i].append(1)
    dp[i].append(a[i])

for i in range(1, n):
    temp = dp[i][0]
    chk = False
    for j in range(i):
        if a[i] > a[j]:
            chk = True
            if temp < dp[j][0]+1:
                temp = dp[j][0]+1
                temp_i = j
    dp[i][0] = temp
    if chk:
        for v in dp[temp_i][1:]:
            dp[i].append(v)

max_ = 0
for i in range(n):
    if max_ < dp[i][0]:
        max_ = dp[i][0]

for i in range(n):
    if dp[i][0] == max_:
        result = dp[i][1:]
        break

result.sort()
print(max_)
print(*result)