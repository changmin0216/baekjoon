import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
result=[]
def recur(cnt, start_index):
    if cnt==m:
        print(*result)
        return
    for i in range(start_index, n):
        result.append(arr[i])
        recur(cnt+1, i)
        result.pop()
recur(0, 0)