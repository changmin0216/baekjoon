import sys
input = sys.stdin.readline

def dfs(node, cnt):
    visited[node] = True

    for i in graph[node]:
        if not visited[i]:
            cnt = dfs(i, cnt+1)
    return cnt

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())

    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())

        graph[a].append(b)
        graph[b].append(a)

    visited = [False] * (n+1)
    print(dfs(1, 0))