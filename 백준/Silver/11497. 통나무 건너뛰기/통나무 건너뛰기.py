import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    tree = list(map(int, input().split()))

    tree.sort()

    result = 0
    for i in range(2, n):
        result = max(result, abs(tree[i] - tree[i-2]))
    print(result)

