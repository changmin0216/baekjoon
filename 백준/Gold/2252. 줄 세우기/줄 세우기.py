import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, m = map(int, input().split())
degree = [0 for _ in range(n+1)]
g = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    degree[b]+=1

q = deque()
for i in range(1, n+1):
    if degree[i] == 0:
        q.append(i)

answer = []
while q:
    x = q.popleft()
    answer.append(x)

    for i in g[x]:
        degree[i]-=1
        if degree[i] == 0:
            q.append(i)
if len(answer)!=n:
    print("사이클 발생")
else:
    print(' '.join(map(str, answer)))