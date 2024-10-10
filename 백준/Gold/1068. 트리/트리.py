import sys
input = sys.stdin.readline

# n<=50

n = int(input())
tree = list(map(int, input().split()))
del_node = int(input())

if tree[del_node] == -1:
    print(0)
    exit(0)
def del_recur(node):
    tree[node] = -2
    for i in range(n):
        if tree[i] == node:
            del_recur(i)
    return

tree[del_node] = -2
for i in range(n):
    if tree[i] == del_node:
        del_recur(i)

cnt = 0
for i in range(n):
    if tree[i]!=-2:
        for j in range(n):
            if tree[j] == i and i!=j:
                break
        else:
            cnt+=1
print(cnt)