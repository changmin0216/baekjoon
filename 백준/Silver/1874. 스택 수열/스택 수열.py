import sys
input = sys.stdin.readline
# 0 <= n <=100,000
n = int(input())

ary = []
for i in range(1, n+1):
    ary.append(i)
sol = []
stack = []
m = 1
possible = True
for _ in range(n):
    k = int(input())
    while m <= k:
        stack.append(m)
        sol.append('+')
        m+=1
    if stack[-1] == k:
        stack.pop()
        sol.append('-')
    else:
        possible = False
        break

if possible:
    print('\n'.join(sol))
else:
    print('NO')