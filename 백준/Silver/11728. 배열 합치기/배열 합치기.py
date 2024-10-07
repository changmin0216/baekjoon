import sys
input = sys.stdin.readline

n, m = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.extend(b)

a.sort()
print(' '.join(map(str, a)))