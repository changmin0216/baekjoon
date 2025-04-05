n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)
def dfs(num):
    visited[num] = True

    for i in graph[num]:
        if not visited[i]:
            dfs(i)

dfs(1)

result = 0
for i in range(n+1):
    if visited[i]:
        result+=1
print(result-1)