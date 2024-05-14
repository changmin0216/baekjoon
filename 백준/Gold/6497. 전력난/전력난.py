import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

while True:
    m, n = map(int, input().split()) # 집의 수 m, 갈의 수 n
    if m == 0 and n==0:
        break

    edges = []

    total = 0
    for i in range(n):
        edge = list(map(int, input().split()))
        total += edge[2]
        edges.append(edge)

    edges.sort(key=lambda x: x[2])

    parent = [0 for _ in range(m)]

    for i in range(m):
        parent[i] = i

    result = 0
    for edge in edges:
        a, b, cost = edge

        if find_parent(parent, a) != find_parent(parent, b):
            result += cost
            union_parent(parent, a, b)

    print(total - result)