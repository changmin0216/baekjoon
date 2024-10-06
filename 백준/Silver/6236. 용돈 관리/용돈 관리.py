import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = []
for _ in range(n):
    arr.append(int(input()))

left = 1
right = 10**9

answer = 0
while left <= right:
    mid = (left+right)//2

    now = 0
    pick = 0
    flag = True
    for i in arr:
        if i > now:
            if i > mid:
                flag = False
                break
            now = mid-i
            pick+=1
        else:
            now-=i
    if flag:
        if pick > m:
            left = mid + 1
        else: ##최대한 작게
            answer = mid
            right = mid - 1
    else:
        left = mid + 1
print(left)