import sys
input = sys.stdin.readline

n = int(input())
rows = [0] * n
result = 0

def check(x):
    for i in range(x):
        if rows[x]==rows[i] or abs(rows[i]-rows[x])==abs(i-x):
            return False
    return True

def dfs(x):
    global result
    if x==n:
        result+=1
    else:
        for i in range(n):
            rows[x] = i
            if check(x):
                dfs(x+1)
dfs(0)
print(result)