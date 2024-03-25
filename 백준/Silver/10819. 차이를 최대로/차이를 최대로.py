import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

result = []
for v in permutations(arr, n):
    sum = 0
    for i in range(0, n-1):
        sum+=abs(v[i]-v[i+1])
    result.append(sum)
print(max(result))