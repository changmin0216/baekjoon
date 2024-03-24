import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
result=[]
def recur(cnt):
    if cnt==m:
        print(*result)
        return
    for i in range(n):
        result.append(arr[i])
        recur(cnt+1)
        result.pop()
recur(0)