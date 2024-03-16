import math
import sys
input = sys.stdin.readline

prime = [True] * 1000001
prime[1] = False
# 소수 list
for i in range(2, int(math.sqrt(1000000))+1):
    if prime[i]:
        j=2
        while i*j<=1000000:
            prime[i*j] = False
            j+=1

while True:
    n = int(input())
    if n == 0:
        break

    for i in range(3, n-2, 2):
        if prime[i] and prime[n-i]:
            print('{} = {} + {}'.format(n,i,n-i))
            break
    else:
        print("Goldbach's conjecture is wrong.")
