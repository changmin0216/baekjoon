import sys
input = sys.stdin.readline

n, m, y, x, k = map(int, input().split())

g=[]
for _ in range(n):
    g.append(list(map(int, input().split())))

dice_row = [0,0,0,0]
dice_col = [0,0,0,0]

d = [0, [0,1], [0,-1], [-1,0],[1,0]]

com = list(map(int, input().split()))


for c in com:
    ny, nx = y+d[c][0], x+d[c][1]
    if not (0 <= ny < n and 0 <= nx < m):
        continue
    if c==1:
        dice_row[0], dice_row[1], dice_row[2], dice_row[3] = dice_row[1], dice_row[2], dice_row[3], dice_row[0]
        dice_col[1] = dice_row[1]
        dice_col[3] = dice_row[3]
    elif c==2:
        dice_row[0], dice_row[1], dice_row[2], dice_row[3] = dice_row[3], dice_row[0], dice_row[1], dice_row[2]
        dice_col[1] = dice_row[1]
        dice_col[3] = dice_row[3]
    elif c==3:
        dice_col[0], dice_col[1],dice_col[2],dice_col[3] = dice_col[3], dice_col[0], dice_col[1], dice_col[2]
        dice_row[1] = dice_col[1]
        dice_row[3] = dice_col[3]
    else:
        dice_col[0], dice_col[1], dice_col[2], dice_col[3] = dice_col[1], dice_col[2], dice_col[3], dice_col[0]
        dice_row[1] = dice_col[1]
        dice_row[3] = dice_col[3]

    if g[ny][nx] == 0:
        g[ny][nx] = dice_row[1]
    else:
        dice_row[1], dice_col[1] = g[ny][nx], g[ny][nx]
        g[ny][nx] = 0
    print(dice_col[3])
    y, x = ny, nx