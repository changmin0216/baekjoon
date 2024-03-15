import sys
input = sys.stdin.readline

x, y = map(int, input().split())

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

print(gcd(x, y))
print(int(x*y/gcd(x, y)))