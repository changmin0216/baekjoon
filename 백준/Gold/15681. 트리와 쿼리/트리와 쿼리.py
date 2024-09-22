import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n, r, q = map(int, input().split()) #트리의 정점의 수, 루트의 번호, 쿼리의 수

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = [0] * (n+1)

def dfs(root):
    cnt[root] = 1
    for i in graph[root]:
        if not cnt[i]:
            dfs(i)
            cnt[root]+=cnt[i]

    return

dfs(r)

for _ in range(q):
    print(cnt[int(input())])
