import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    c = {}
    for _ in range(n):
        name, category = map(str, input().split())
        if c.get(category):
            c[category].append(name)
        else:
            c[category] = [name]
    result = 1
    for i in c:
        result*=(len(c[i])+1)
    print(result-1)
