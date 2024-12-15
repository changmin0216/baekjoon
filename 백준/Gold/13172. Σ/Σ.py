import sys
from math import gcd
input = sys.stdin.readline
MOD = 1000000007

m = int(input())

answer = 0
for _ in range(m):
    a, b = map(int, input().split())
    a, b = a//gcd(a, b), b//gcd(a, b),
    answer += (b*pow(a, -1, MOD)%MOD)
print(answer%MOD)