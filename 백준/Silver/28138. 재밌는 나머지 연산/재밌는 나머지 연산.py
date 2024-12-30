import sys
input = sys.stdin.readline

n, r = map(int, input().split())

ans = 0
p = n - r
for i in range(1, int(p**0.5)+1):
    if p%i == 0:
        if i>r:
            ans+=i
        if i**2!=p and p//i>r:
            ans+=p//i
print(ans)