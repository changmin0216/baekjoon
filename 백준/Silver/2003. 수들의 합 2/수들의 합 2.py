import sys
input = sys.stdin.readline

N, M = map(int, input().split())

A = list(map(int, input().split()))
cnt = 0

left, right = 0, 1
while right<=N and left<=right:
    section = A[left:right]
    total_sum = sum(section)

    if total_sum == M:
        cnt+=1
        right+=1
    elif total_sum > M:
        left+=1
    else:
        right+=1

print(cnt)