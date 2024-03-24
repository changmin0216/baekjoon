import sys
input = sys.stdin.readline

n, m = map(int, input().split())

rs = []
def recur(start):
    if len(rs) == m:
        print(*rs)
        return

    for i in range(start, n+1):
        rs.append(i)
        recur(i)
        rs.pop()

recur(1)