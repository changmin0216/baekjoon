import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x]!=x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())

edges = []

parent = [0] * (n+1)

for i in range(1, n+1):
    parent[i] = i

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

edges.sort(key=lambda x:x[2])

result = []

for edge in edges:
    a, b, cost = edge
    if find_parent(parent, a) != find_parent(parent, b):
        result.append(cost)
        union_parent(parent, a, b)

print(sum(result)-max(result))