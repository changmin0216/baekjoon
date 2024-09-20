import sys
input = sys.stdin.readline

n = int(input())

graph = []
for i in range(n):
    t = list(map(int, input().split()))
    for j in range(len(t)):
        if t[j]!=0:
            graph.append([i, j, t[j]])
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

result = 0

graph.sort(key=lambda x:x[2])

parent = [0] * n

for i in range(n):
    parent[i] = i

for i in graph:
    if find_parent(parent, i[0])!=find_parent(parent, i[1]):
        result+=i[2]
        union_parent(parent, i[0], i[1])

print(result)
