import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
visited = [False for _ in range(n)]
arr.sort()

temp = []
def recur():
    if len(temp) == m:
        print(*temp)
    prev = 0
    for i in range(n):
        if not visited[i] and prev!=arr[i]:
            visited[i] = True
            temp.append(arr[i])
            prev=arr[i]
            recur()
            visited[i] = False
            temp.pop()
recur()