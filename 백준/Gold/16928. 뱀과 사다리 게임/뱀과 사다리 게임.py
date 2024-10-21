import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, m = map(int, input().split())

ladder = defaultdict(int)
for _ in range(n):
    a, b = map(int, input().split())
    ladder[a] = b

snake = defaultdict(int)
for _ in range(m):
    a, b = map(int, input().split())
    snake[a] = b

q = deque()
q.append((1, 0))

visited = [False] * 101
visited[1] = True
while q:
    x, cnt = q.popleft()
    if x == 100:
        print(cnt)
        break
    for next in [x+1, x+2, x+3, x+4, x+5, x+6]:

        if next in ladder:
            next = ladder[next]

        if next in snake:
            next = snake[next]

        if 0<=next<101 and not visited[next]:
            visited[next] = True
            q.append((next, cnt+1))