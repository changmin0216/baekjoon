import sys
input = sys.stdin.readline

n = int(input())

ary = []
for _ in range(n):
    ary.append(int(input()))

ary.sort()
for v in ary:
    print(v)