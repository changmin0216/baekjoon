import sys
input = sys.stdin.readline

x, y, z, r = map(int, input().split())

a = x * (10**len(str(y))) + y
b = z * (10**len(str(r))) + r

print(a+b)