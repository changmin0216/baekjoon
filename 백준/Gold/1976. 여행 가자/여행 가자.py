import sys
input = sys.stdin.readline
def find(parent, x):
    if parent[x]!=x:
        parent[x] = find(parent, parent[x])
    return parent[x]
def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
m = int(input())


parent = [i for i in range(n+1)]

for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(len(tmp)):
        if tmp[j]==1:
            union(parent, i+1, j+1)

plan = list(map(int, input().split()))

start = parent[plan[0]]

for i in range(1, m):
    if parent[plan[i]]!=start:
        print('NO')
        break
else:
    print("YES")