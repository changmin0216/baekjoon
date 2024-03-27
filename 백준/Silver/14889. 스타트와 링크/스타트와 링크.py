import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())

arr = []
result = sys.maxsize
for _ in range(n):
    arr.append(list(map(int, input().split())))

l = [i for i in range(n)]
a = []
for v in combinations(l, n//2):
    a.append(v)

for i in range(len(a)//2):
    x=0
    y=0
    for q in combinations(a[i], 2):
        x+=arr[q[0]][q[1]]+arr[q[1]][q[0]]

    for w in combinations(a[-(i+1)], 2):
        y+=arr[w[0]][w[1]]+arr[w[1]][w[0]]

    result = min(abs(x-y), result)

print(result)