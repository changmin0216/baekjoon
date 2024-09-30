import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

v = int(input())

tree = [[] for _ in range(v+1)]
for _ in range(v):
    temp = list(map(int, input().split()))

    st = temp[0]
    for i in range(1, len(temp), 2):
        if temp[i]==-1:
            continue
        tree[st].append([temp[i], temp[i+1]])

distance = [-1] * (v+1)
distance[1] = 0
def dfs(start, dist):
    for i in tree[start]:
        if distance[i[0]]==-1:
            distance[i[0]] = dist + i[1]
            dfs(i[0], distance[i[0]])
    return

dfs(1, 0)

start = distance.index(max(distance))
distance = [-1] * (v+1)
distance[start] = 0
dfs(start, 0)

print(max(distance))