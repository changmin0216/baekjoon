import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = []
chk = [False for _ in range(n)]
def recur(cnt):
    if cnt==m:
        print(*result)
        return
    for i in range(n):
        if chk[i] == False:
            chk[i] = True
            result.append(arr[i])
            recur(cnt+1)
            chk[i] = False
            result.pop()

recur(0)