import sys
input = sys.stdin.readline

n, m = map(int, input().split())

chk = [False for _ in range(n+1)]
result = []

def recur(num):
    if num==m:
        print(*result)
        return
    for i in range(1, n+1):
        if chk[i] == False:
            chk[i] = True
            result.append(i)
            recur(num+1)
            chk[i] = False
            result.pop()

recur(0)