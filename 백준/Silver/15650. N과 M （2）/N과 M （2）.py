import sys
input = sys.stdin.readline

n, m = map(int, input().split())

rs = []
chk = [False] * (n+1)

def recur(num, start):
    if num == m:
        print(' '.join(map(str, rs)))
        return
    for i in range(start, n+1):
        if chk[i] == False:
            chk[i] = True
            rs.append(i)
            recur(num+1, i)
            chk[i] = False
            rs.pop()

recur(0, 1)