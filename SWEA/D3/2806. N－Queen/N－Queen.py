def check(row):
    for i in range(row):
        if column[i] == column[row] or row - i == abs(column[i] - column[row]):
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

t = int(input())

for i in range(t):
    n = int(input())

    column = [-1] * n
    result = 0

    dfs(0)
    print(f'#{i+1} {result}')