import math
import sys
input = sys.stdin.readline

n = int(input())

ary = list(map(int, input().split()))

cnt=0
for v in ary:
    chk = True
    if v == 1:
        continue
    for i in range(2, int(math.sqrt(v))+1):
        if v%i == 0:
            chk = False
            break
    if chk:
        cnt+=1
print(cnt)
