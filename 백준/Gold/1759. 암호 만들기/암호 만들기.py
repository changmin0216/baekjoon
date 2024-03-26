import sys
input = sys.stdin.readline
from itertools import permutations, combinations

l, c = map(int, input().split())
arr = list(map(str, input().split()))

arr.sort()
cnt_a=0
cnt_b=0
for v in combinations(arr, l):
    cnt_a = 0
    cnt_b = 0
    for r in v:
        if r in ['a','e','i','o','u']:
            cnt_a+=1
        else:
            cnt_b+=1
    if cnt_a > 0 and cnt_b > 1:
        print(''.join(v))