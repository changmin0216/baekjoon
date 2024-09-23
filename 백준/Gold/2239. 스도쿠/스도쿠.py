import sys
input = sys.stdin.readline

zero = []
ary = []

for i in range(9):
    tmp = list(map(int, input().rstrip()))
    for j in range(9):
        if tmp[j]==0:
            zero.append((i, j))
    ary.append(tmp)

def check_row(num, ey, ex):
    for i in range(9):
        if num==ary[ey][i]:
            return False
    return True

def check_col(num, ey, ex):
    for i in range(9):
        if num==ary[i][ex]:
            return False
    return True

def check_three(num, ey, ex):
    ny = (ey//3)*3
    nx = (ex//3)*3

    for i in range(3):
        for j in range(3):
            if ary[ny+i][nx+j] == num:
                return False
    return True

def dfs(depth):
    if depth >= len(zero):
        for i in range(9):
            for j in range(9):
                print(ary[i][j], end='')
            print()
        exit()

    ey, ex = zero[depth]

    for i in range(1, 10):
        if check_col(i, ey, ex) and check_row(i, ey, ex) and check_three(i, ey, ex):
            ary[ey][ex] = i
            dfs(depth+1)
            ary[ey][ex] = 0

dfs(0)