import sys
from collections import Counter
from collections import defaultdict
input = sys.stdin.readline

n, d, k, c = map(int, input().split()) 
arr = []
for _ in range(n):
    arr.append(int(input()))

if k == n:
    c = Counter(arr)
    print(len(c))
    exit(0)
else:
    max_ = -1
    for i in range(n):
        d = defaultdict(int)
        for j in range(k):
            index = (i+j)%n
            d[arr[index]]+=1
        d[c]+=1
        max_ = max(max_, len(d))
print(max_)

