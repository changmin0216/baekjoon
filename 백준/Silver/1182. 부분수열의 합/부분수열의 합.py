import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

cnt=0
temp = []
def recur(index):
    global cnt
    if sum(temp) == s and len(temp)!=0:
        cnt+=1
    for i in range(index, n):
        temp.append(arr[i])
        recur(i+1)
        temp.pop()
    return
recur(0)
print(cnt)