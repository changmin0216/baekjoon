import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def find_parent(parent, x):
    if parent[x]!=x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())

edges = []
for _ in range(e):
    a,b,c = map(int, input().split())
    edges.append((a,b,c))

edges.sort(key=lambda x:x[2])

parent = [i for i in range(v+1)]
result = 0
cnt = 0
while cnt< v-1:
    for edge in edges:
        a, b, c = edge
        if find_parent(parent, a)!=find_parent(parent, b):
            result+=c
            cnt+=1
            union_parent(parent, a, b)
print(result)