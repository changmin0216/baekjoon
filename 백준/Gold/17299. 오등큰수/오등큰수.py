import sys
from collections import Counter

input = sys.stdin.readline

N = int(input())
ary = list(map(int, input().split()))
cnt_num = Counter(ary)
stack = []
answer = [-1] * N
for i in range(N):
    while stack and cnt_num[ary[stack[-1]]] < cnt_num[ary[i]]:
        answer[stack.pop()] = ary[i]
    stack.append(i)
print(*answer)
