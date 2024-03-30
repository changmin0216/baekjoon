import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(k, color):
    visited[k] = color

    for i in g[k]:
        if not visited[i]:
            a = dfs(i, -color)
            if not a:
                return False
        elif visited[i] == visited[k]:
            return False
    return True

k = int(input()) # 테스트 케이스 개수

for i in range(k):
    v, e = map(int, input().split()) # 정점의 개수, 간선의 개수
    g = [[] for _ in range(v+1)]
    for _ in range(e):
        a, b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)
    visited = [0] * (v+1)
    for i in range(1, v+1):
        if not visited[i]:
            visited[i] = 1
            result = dfs(i, 1)

            if not result:
                break
    if result:
        print('YES')
    else:
        print('NO')