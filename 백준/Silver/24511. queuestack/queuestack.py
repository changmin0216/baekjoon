import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))  
b = list(map(int, input().split())) 

m = int(input())
c = list(map(int, input().split()))

result = deque()

for i in range(n):
    if a[i] == 0:
        result.appendleft(b[i])

for i in range(m):
    result.append(c[i])
    print(result.popleft(), end=' ')