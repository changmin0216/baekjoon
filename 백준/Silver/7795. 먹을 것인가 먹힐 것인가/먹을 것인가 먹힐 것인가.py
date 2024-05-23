import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    B.sort()

    cnt = 0
    for i in range(n):

        left = 0
        right = m-1
        while left <= right:
            mid = (left + right) // 2

            if A[i] > B[mid]:
                left = mid + 1
            else:
                right = mid - 1
        cnt+=left
    print(cnt)