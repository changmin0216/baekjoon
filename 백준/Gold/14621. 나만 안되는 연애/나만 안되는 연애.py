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
u = list(map(str, input().split()))

g = []
for _ in range(m):
    a, b, c = map(int, input().split())
    g.append([a, b, c])

g.sort(key=lambda x:x[2])

parent = [0]*(n+1)

for i in range(1, n+1):
    parent[i] = i

result = 0
cnt = 0
for i in g:
    if find_parent(parent, i[0]) != find_parent(parent, i[1]) and u[i[0]-1]!=u[i[1]-1]:
        result+=i[2]
        cnt+=1
        union_parent(parent, i[0], i[1])
if cnt==n-1:
    print(result)
else:
    print(-1)