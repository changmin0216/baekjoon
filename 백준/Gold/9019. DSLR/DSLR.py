import sys
from collections import deque
input = sys.stdin.readline

t = int(input())


for _ in range(t):
    visited = [False] * 10000
    a, b = map(int, input().split())
    visited[a] = True

    q = deque()
    q.append((a,''))

    while q:
        x, s = q.popleft()

        if x==b:
            print(s)
            break

        n1 = x*2
        if n1 > 9999:
            n1 = n1%10000

        n2 = x-1
        if n2 == -1:
            n2 = 9999

        n3 = (x % 1000 * 10) + x // 1000

        n4 = (x%10 * 1000) + x//10
        for num, c in [(n1, 'D'), (n2, 'S'), (n3, 'L'), (n4, 'R')]:
            if not visited[num]:
                visited[num] = True
                q.append((num, s+c))