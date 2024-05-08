import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start = max(arr)
end = sum(arr)

while start <= end:
    mid = (start + end) // 2

    total = 0
    cnt = 1
    for v in arr:
        if total + v > mid:
            cnt+=1
            total = 0
        total+=v

    if cnt <= m:
        end = mid-1
        ans = mid
    else:
        start = mid+1
print(ans)