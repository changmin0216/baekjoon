import sys
input = sys.stdin.readline

t = int(input())

p = [0,1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
# p = [0] * 101
for _ in range(t):
    n = int(input())
    if n<=(len(p)-1):
        print(p[n])
    else:
        for i in range(len(p), n+1):
            p.append(p[i-2]+p[i-3])

        print(p[n])