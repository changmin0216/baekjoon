import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

chk = [False for _ in range(n)]
arr.sort()
result=[]
def recur(cnt, start_index):
    if cnt==m:
        print(*result)
        return
    for i in range(start_index, n):
        if chk[i]==False:
            chk[i] = True
            result.append(arr[i])
            recur(cnt+1, i)
            chk[i]=False
            result.pop()
recur(0, 0)