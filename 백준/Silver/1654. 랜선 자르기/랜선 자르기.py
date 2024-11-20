import sys
input = sys.stdin.readline

k, n = map(int, input().split()) # 총 필요한 랜선의 개수는 n개

arr = []
for _ in range(k):
    arr.append(int(input()))

answer = 0
left = 1
right = (2**31)-1
while left<=right:
    mid = (left+right)//2

    sum = 0
    for x in arr:
        sum+=x//mid

    if sum>=n:
        answer = mid
        left = mid + 1
    else:
        right = mid-1

print(answer)