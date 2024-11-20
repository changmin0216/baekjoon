import sys
input = sys.stdin.readline

n, k = map(int, input().split())

down = 1
for i in range(1,k+1):
    down*=i

up = 1
for i in range(n, n-k, -1):
    up*=i

print((up//down)%10007)