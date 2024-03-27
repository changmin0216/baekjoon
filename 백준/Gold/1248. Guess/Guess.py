import sys
input = sys.stdin.readline

n = int(input())
sign = [[0]*n for _ in range(n)]
a = list(input())
k = 0
v = []

def possible(idx):
    s = 0
    for i in range(idx, -1, -1):
        s+=v[i]
        if sign[i][idx] == '+' and s<=0:
            return False
        if sign[i][idx] == '0' and s!=0:
            return False
        if sign[i][idx] == '-' and s >= 0:
            return False
    return True

def solve(idx):
    if idx == n:
        print(' '.join(map(str, v)))
        exit()
    for i in range(-10, 11):
        v.append(i)
        if possible(idx):
            solve(idx+1)
        v.pop()

for i in range(n):
    for j in range(i, n):
        sign[i][j] = a[k]
        k += 1

solve(0)