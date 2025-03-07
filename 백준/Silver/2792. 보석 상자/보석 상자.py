import sys
input = sys.stdin.readline

n, m = map(int, input().split())

jewelry = []
for _ in range(m):
    jewelry.append(int(input()))

left = 1
right = max(jewelry)

while left <= right:
    mid = (left+right)//2

    cnt = 0
    for i in range(m):
        cnt+=jewelry[i]//mid
        if jewelry[i]%mid != 0:
            cnt+=1

    if cnt<=n: #조건을 만족한다.
        answer = mid
        right = mid -1
    else:
        left = mid + 1
print(answer)