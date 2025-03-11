import sys
input = sys.stdin.readline

n, b = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))

def mul(u, v):
    n = len(u)
    z = [[0] * n for _ in range(n)]

    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += u[row][i] * v[i][col]
            z[row][col] = e % 1000

    return z

def square(a, b):
    if b == 1:
        for x in range(len(a)):
            for y in range(len(a)):
                a[x][y] %= 1000
        return a

    tmp = square(a, b // 2)
    if b % 2: ## 짝수
        return mul(mul(tmp, tmp), a)
    else: ## 홀수
        return mul(tmp, tmp)

result = square(a, b)
for r in result:
    print(*r)