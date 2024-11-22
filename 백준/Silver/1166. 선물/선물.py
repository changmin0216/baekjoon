import sys
input = sys.stdin.readline

n, l, w, h = map(int, input().split())

left = 0
right = min(l, w, h)

answer = 0
for i in range(60):
    mid = (left + right) / 2
    cnt = (l//mid) * (w//mid) * (h//mid)

    if cnt>=n:
        answer = mid
        left = mid
    else:
        right = mid
print(answer)