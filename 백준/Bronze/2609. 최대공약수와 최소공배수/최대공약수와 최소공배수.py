import sys
import math
input = sys.stdin.readline

x, y = map(int, input().split())

a = []
b = []

for i in range(1, int(math.sqrt(x))+1):
    if x%i==0:
        a.append(i)
        a.append(int(x/i))

for i in range(1, int(math.sqrt(y))+1):
    if y%i==0:
        b.append(i)
        b.append(int(y/i))
a.sort()
b.sort()
for i in range(len(a)):
    if a[i] in b:
        gcd = a[i]
print(gcd)
print(int(x*y/gcd))
