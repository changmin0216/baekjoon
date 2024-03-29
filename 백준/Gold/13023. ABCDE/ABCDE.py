import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
visited = [False]*2000
def dfs(k, cnt):
    if cnt==5:
        print(1)
        exit()
    for i in arr[k]:
        if not visited[i]:
            visited[i] = True
            dfs(i, cnt+1)
            visited[i] = False

for i in range(n):
    visited[i] = True
    dfs(i, 1)
    visited[i] = False
print(0)