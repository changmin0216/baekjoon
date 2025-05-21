def check(row):
    for i in range(row):
        if column[i] == column[row] or row - i == abs(column[row] - column[i]):
            return False
    return True

def dfs(row):
    global result
    if row == n:
        result+=1
        return

    for i in range(n):
        column[row] = i
        if check(row):
            dfs(row+1)
    return
####################
t = int(input())

for case in range(t):
    n = int(input())

    column = [-1] * n

    result = 0
    dfs(0)

    print(f'#{case+1} {result}')