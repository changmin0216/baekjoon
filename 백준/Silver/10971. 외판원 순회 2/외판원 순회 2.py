import sys
input = sys.stdin.readline

n = int(input())
w = []
for _ in range(n):
    w.append(list(map(int, input().split())))
arr = [i for i in range(n)]
temp = []
visited = [False for _ in range(n)]
s = sys.maxsize
def recur():
    if len(temp)==n:
        sum = 0
        global s
        if w[temp[-1]][temp[0]] == 0:
            return
        else:
            for i in range(len(temp) - 1):
                if w[temp[i]][temp[i + 1]] != 0:
                    sum += w[temp[i]][temp[i + 1]]
                else:
                    return
            sum += w[temp[-1]][temp[0]]
            s = min(s, sum)
            return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            temp.append(arr[i])
            recur()
            visited[i] = False
            temp.pop()
    return
recur()
print(s)