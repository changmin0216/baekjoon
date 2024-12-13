import sys
import bisect
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

lis = []

for x in arr:
    if not lis or x > lis[-1]:
        lis.append(x)
    else:
        index = bisect.bisect_left(lis, x)
        lis[index] = x

print(len(lis))