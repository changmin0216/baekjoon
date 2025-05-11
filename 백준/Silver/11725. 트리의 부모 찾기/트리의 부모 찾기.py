import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(node):
    visited[node] = True

    stack = []
    stack.append(node)

    while stack:
        now = stack.pop()

        for i in tree[now]:
            if not visited[i]:
                parent[i] = now
                visited[i] = True
                stack.append(i)
    return

#########################
### (2 ≤ N ≤ 100,000)
n = int(input())

tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())

    tree[a].append(b)
    tree[b].append(a)

parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

visited = [False] * (n+1)

dfs(1)
for i in range(2, n+1):
    print(parent[i])