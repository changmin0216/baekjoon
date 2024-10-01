from functools import cache

MOD = 1_000_000_007
# 1,000,000,000,000,000,000
@cache
def fib(n):
    if n <= 2:
        return 1
    elif n % 2 == 0:
        return (fib(n//2) * (2*fib(n//2-1) + fib(n//2))) % MOD
    else:
        return (fib(n//2+1)**2 + fib(n//2)**2) % MOD

print(fib(int(input())))