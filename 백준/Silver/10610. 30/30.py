import sys
from itertools import permutations
input = sys.stdin.readline

n = input().rstrip()

if '0' not in n:
    print(-1)
else:
    sum_ = 0 # 각 자릿수의 합
    for i in range(len(n)):
        sum_ += int(n[i])

    if sum_ % 3 != 0:
        print(-1)
    
    else:
        arr = sorted(n, reverse=True)
        print(''.join(arr))