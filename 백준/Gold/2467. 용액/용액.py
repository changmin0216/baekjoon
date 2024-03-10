import sys
input = sys.stdin.readline

N = int(input())

ary = list(map(int, input().split()))

left = 0
right = N-1

sol = [ary[left], ary[right]]
k = abs(sum(sol))

while left < right:
    sum = ary[left] + ary[right]

    if abs(sum) < k:
        k = abs(sum)
        sol = [ary[left], ary[right]]
        if k == 0:
            break
    if sum < 0:
        left+=1
    else:
        right-=1
print(' '.join(map(str, sol)))