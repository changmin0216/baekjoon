import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
visited = [False for _ in range(n)]

temp=[]
def recur(start_index):
    if len(temp) == m:
        print(*temp)
    prev = 0
    for i in range(start_index, n):
        if not visited[i] and prev!=arr[i]:
            visited[i] = True
            temp.append(arr[i])
            prev = arr[i]
            recur(i+1)
            visited[i] = False
            temp.pop()
recur(0)