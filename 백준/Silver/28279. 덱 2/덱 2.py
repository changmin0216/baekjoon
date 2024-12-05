import sys
from collections import deque
n = int(input())

q = deque()
for i in range(n):
    num = list(map(int, sys.stdin.readline().strip().split()))
    l = len(q)
    if num[0] == 1:
        q.appendleft(num[1])
    elif num[0] == 2:
        q.append(num[1])
    elif num[0] == 3:
        print(q.popleft() if l else -1)
    elif num[0] == 4:
        print(q.pop() if l else -1)
    elif num[0] == 5:
        print(len(q))
    elif num[0] == 6:
        print(0 if l else 1)
    elif num[0] == 7:
        print(q[0] if l else -1)
    elif num[0] == 8:
        print(q[-1] if l else -1)