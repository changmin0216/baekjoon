import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(graph, v, visited):
    visited[v] = True
    for vertex in graph[v]:
        if visited[vertex] == False:
            visited[vertex] = True
            dfs(g, vertex, visited)

    return

n, m = map(int, input().split()) #정점개수, 간선개수

g = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

result = 0
for v in range(1, n+1):
    if not visited[v]:
        dfs(g, v, visited)
        result+=1

print(result)