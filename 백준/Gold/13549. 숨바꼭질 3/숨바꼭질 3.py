import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

def solve():
    q = deque()

    q.append((n, 0))
    visited = [False] * 100001
    visited[n] = True

    while q:
        now, time = q.popleft()

        if now == k:
            return time

        for i in range(3):
            if i==0:
                next = now*2
                next_time = time
            elif i==1:
                next = now-1
                next_time = time+1
            elif i==2:
                next = now+1
                next_time = time+1

            if 0<=next<100001 and not visited[next]:
                visited[next] = True
                q.append((next, next_time))

print(solve())