import sys
input = sys.stdin.readline
from collections import deque

N, K = map(int, input().split())

q = deque()

ary = []
for i in range(1, N+1):
    ary.append(i)

sol = []
num = 0
for _ in range(N):
    num+=K-1
    if num >= len(ary):
        num = num%(len(ary))
    sol.append(ary.pop(num))
print('<'+', '.join(map(str, sol))+'>')