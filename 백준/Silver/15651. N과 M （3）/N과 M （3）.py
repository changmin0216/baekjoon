import sys
input = sys.stdin.readline

n, m = map(int, input().split())

result = []

def recur(num):
    if num == m:
        print(*result)
        return
    for i in range(1, n+1):
        result.append(i)
        recur(num+1)
        result.pop()
recur(0)
