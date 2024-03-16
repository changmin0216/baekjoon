import math
import sys
input = sys.stdin.readline

m, n = map(int, input().split())

prime = [True for _ in range(n+1)]

prime[1] = False

for i in range(2, int(math.sqrt(n))+1):
    if prime[i] == True:
        j = 2
        while i * j <= n:
            prime[i*j] = False
            j += 1
for i in range(m, n+1):
    if prime[i]==True:
        print(i)