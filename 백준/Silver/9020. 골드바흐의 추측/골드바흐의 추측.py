import sys
input = sys.stdin.readline

def is_prime(x):
    if x==1:
        return False
    for i in range(2, int(x**0.5)+1):
        if x%i==0:
            return False
    return True

t = int(input())

for _ in range(t):
    n = int(input())

    result = 0
    for i in range(1, n//2+1):
        if is_prime(i) and is_prime(n-i):
            result = i
    print(result, n-result)