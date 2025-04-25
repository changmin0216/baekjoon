import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())
m = int(input())

arr = list(map(int, input().split()))

# arr.sort()

cnt = 0
for k in combinations(arr, 2):
    if k[0]+k[1] == m:
        cnt+=1
print(cnt)