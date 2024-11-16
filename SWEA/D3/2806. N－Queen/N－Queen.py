def promising(row):
    for i in range(row):
        if column[row] == column[i] or row - i == abs(column[row] - column[i]):
            # 퀸이 같은 대각선 또는 열에 존재한다면 탐색 중지
            return False
    return True


def dfs(row):
    global result
    if row == n:  # n 번째 행 퀸까지 결정 됐다면
        result += 1
    else:
        for col in range(n):
            column[row] = col
            if promising(row):
                dfs(row+1)

t = int(input())

for i in range(t):
    n = int(input())
    
    column = [-1]*n  # i번째 행에 위치한 퀸의 열 위치
    result = 0

    dfs(0)

    print("#{} {}".format(i+1, result))