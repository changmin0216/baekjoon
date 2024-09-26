import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

left = 1
right = max(arr)

result = 0
while left <= right:
    mid = (left + right) // 2

    sum=0
    for i in arr:
        temp = i-mid
        if temp>=0:
            sum+=temp

    if sum>=m:
        left = mid + 1
        result = mid
    else:
        right = mid - 1

print(result)