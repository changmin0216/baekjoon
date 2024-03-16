import sys
input = sys.stdin.readline

def gcd(a, b):
    while b>0:
        a, b = b, a%b
    return a

n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    lcm = int(a*b/gcd(a, b))
    print(lcm)