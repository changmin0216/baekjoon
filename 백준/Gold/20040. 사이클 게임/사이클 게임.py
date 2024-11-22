import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x]!=x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())

parent = [0] * n
for i in range(n):
    parent[i] = i

edges = []
for _ in range(m):
    edges.append(list(map(int, input().split())))

answer = -1
for i in range(m):
    if find_parent(parent, edges[i][0]) != find_parent(parent, edges[i][1]):
        union(parent, edges[i][0], edges[i][1])
    else:
        print(i+1)
        exit(0)
print(0)