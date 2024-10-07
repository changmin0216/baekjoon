import sys
import math
input = sys.stdin.readline

n = int(input())

prime = []
for i in range(2, n+1):
    for j in range(2, int(math.sqrt(i))+1):
        if i%j==0:
            break
    else:
        prime.append(i)

s = 0
e = 0
cnt = 0
while e <= len(prime):
    temp = sum(prime[s:e])

    if temp == n:
        e+=1
        cnt+=1
    elif temp > n:
        s+=1
    else:
        e+=1
print(cnt)