import sys
input = sys.stdin.readline

n = int(input())

corridor = []
teacher = []
for i in range(n):
    tmp = list(map(str, input().split()))
    for j in range(len(tmp)):
        if tmp[j]=='T':
            teacher.append([i,j])
    corridor.append(tmp)

dx = [0,0,-1,1]
dy = [-1,1,0,0]
def check_safe(corridor):

    for x in teacher:

        ## 하
        for i in range(x[0], n):
            if corridor[i][x[1]]=='S':
                return
            elif corridor[i][x[1]]=='O':
                break

        ## 상
        for i in range(x[0],-1,-1):
            if corridor[i][x[1]]=='S':
                return
            elif corridor[i][x[1]]=='O':
                break
        ## 좌
        for i in range(x[1],-1,-1):
            if corridor[x[0]][i]=='S':
                return
            elif corridor[x[0]][i]=='O':
                break

        ## 우
        for i in range(x[1],n):
            if corridor[x[0]][i]=='S':
                return
            elif corridor[x[0]][i]=='O':
                break
    print('YES')
    exit(0)

def make_wall(corridor, num):
    if num==3:
        check_safe(corridor)
        return

    for i in range(n):
        for j in range(n):
            if corridor[i][j]=='X':
                corridor[i][j]='O'
                make_wall(corridor, num+1)
                corridor[i][j]='X'
    return

make_wall(corridor, 0)
print('NO')