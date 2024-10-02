import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

s, e = 0, 0
fruit_cnt = defaultdict(int)

result = 0

while e < n:
    fruit_cnt[arr[e]]+=1

    while len(fruit_cnt) > 2:
        fruit_cnt[arr[s]]-=1
        if fruit_cnt[arr[s]] == 0:
            del fruit_cnt[arr[s]]
        s+=1

    result = max(result, e-s+1)
    e+=1
print(result)