def is_prime(num):
    if num <= 1:
        return False
    for i in range(2, int(num**0.5)+1):
        if num%i==0:
            return False
    return True

def prime_factorization(num):
    factors = []
    x = 2
    while x**2 <= num:
        if num%x==0:
            factors.append(x)
            num//=x
        else:
            x+=1
    if num > 1:
        factors.append(num)
    return factors

def solve(num):
    return is_prime(len(prime_factorization(num)))

a, b = map(int, input().split())

count = 0
for num in range(a, b + 1):
    if solve(num):
        count += 1
print(count)