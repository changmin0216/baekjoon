import sys, math
input = sys.stdin.readline

t = int(input())

prime = [True] * (10**6+1)
prime[1] = False
for i in range(2, int(math.sqrt(10**6+1))):
    if prime[i] == True:
        j = 2
        while i*j<=10**6:
            prime[i*j] = False
            j+=1

for _ in range(t):
    n = int(input())
    cnt=0
    for i in range(n//2+1):
        if prime[i] and prime[n-i]:
            cnt+=1
    print(cnt)