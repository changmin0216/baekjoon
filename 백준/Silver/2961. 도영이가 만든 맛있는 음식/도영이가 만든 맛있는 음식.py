import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

answer = sys.maxsize
def dfs(depth, mul, plus,  start_index):
    global answer
    if depth < n:
        answer = min(answer, abs(mul-plus))
    else:
        return

    for i in range(start_index, n):
        dfs(depth+1, mul*arr[i][0], plus+arr[i][1], i+1)

for i in range(n):
    dfs(0, arr[i][0], arr[i][1], i+1)

print(answer)