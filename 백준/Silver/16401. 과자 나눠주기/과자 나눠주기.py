import sys
input = sys.stdin.readline

m, n = map(int, input().split())

snack = list(map(int, input().split()))

left = 1
right = 10**9

answer = 0

while left <= right:
    mid = (left + right) // 2

    sum = 0
    for i in range(n):
        sum+=(snack[i]//mid)

    if sum >= m:
        left = mid + 1
        answer = max(mid, answer)
    else:
        right = mid - 1

print(answer)