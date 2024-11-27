import sys
input = sys.stdin.readline

def is_prime(n):
    if n==1:
        return False
    for i in range(2, int((n**0.5))+1):
        if n%i==0:
            return False
    return True

def find_prime(n):
    cnt = 0
    for i in range(n+1, n*2+1):
        if is_prime(i):
            cnt+=1
    return cnt

while True:
    n = int(input())
    if n==0:
        break

    print(find_prime(n))
