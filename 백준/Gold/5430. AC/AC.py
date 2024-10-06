import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    p = list(input().rstrip())
    n = int(input())

    arr = input().rstrip()[1:-1].split(',')
    q = deque(arr)

    r = 0
    if n==0:
        q = []
    for i in p:
        if i == 'R':
            r+=1
        else:
            if q:
                if r%2==0:
                    q.popleft()
                else:
                    q.pop()
            else:
                print("error")
                break
    else:
        if r%2==1:
            q.reverse()
        print('['+','.join(q)+']')