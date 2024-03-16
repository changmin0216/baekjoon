import sys
input = sys.stdin.readline

def gcd(a, b):
    while b > 0:
        a, b = b, a%b
    return a

n = int(input())
for _ in range(n):
    result = 0
    ary = list(map(int, input().split()))
    for i in range(1, ary[0]):
        for j in range(i+1, ary[0]+1):
            result+=gcd(ary[i], ary[j])
    print(result)