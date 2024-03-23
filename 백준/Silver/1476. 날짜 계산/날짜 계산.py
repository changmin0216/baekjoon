import sys
input = sys.stdin.readline

E, M, S = map(int, input().split())
e, m, s = 0, 0, 0
result = 0

while 1:
    e, m, s = e+1, m+1, s+1
    if e==16:
        e=1
    if m==29:
        m=1
    if s==20:
        s=1
    result+=1
    if e==E and m==M and s==S:
        print(result)
        break