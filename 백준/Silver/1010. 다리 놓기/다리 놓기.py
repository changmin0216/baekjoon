import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())

    a, b = 1, 1

    for i in range(m, m-n, -1):
        a*=i
    for i in range(1, n+1):
        b*=i
    print(a//b)
