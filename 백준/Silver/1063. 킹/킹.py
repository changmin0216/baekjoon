import sys
input = sys.stdin.readline

k_p, stone_p, k = input().rstrip().split()

k_pos = [k_p[0], k_p[1]]
k_pos[0] = int(ord(k_pos[0]) - ord('A'))
k_pos[1] = int(k_pos[1]) - 1

stone_pos = [stone_p[0], stone_p[1]]
stone_pos[0] = int(ord(stone_pos[0]) - ord('A'))
stone_pos[1] = int(stone_pos[1]) - 1

for _ in range(int(k)):
    com = input().rstrip()

    if com == 'R': # 한 칸 오른쪽으로
        flag = False
        k_pos[0]+=1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0]+=1

        if k_pos[0] >= 8 or stone_pos[0] >= 8:
            if flag:
                k_pos[0]-=1
                stone_pos[0]-=1
            else:
                k_pos[0]-=1

    elif com == 'L': # 한 칸 왼쪽으로
        flag = False
        k_pos[0] -= 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0] -= 1

        if k_pos[0] < 0 or stone_pos[0] < 0:
            if flag:
                k_pos[0] += 1
                stone_pos[0] += 1
            else:
                k_pos[0] += 1

    elif com == 'B': # 한 칸 아래로
        flag = False
        k_pos[1] -= 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[1] -= 1

        if k_pos[1] < 0 or stone_pos[1] < 0:
            if flag:
                k_pos[1] += 1
                stone_pos[1] += 1
            else:
                k_pos[1] += 1

    elif com == 'T': # 한 칸 위로
        flag = False
        k_pos[1] += 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[1] += 1

        if k_pos[1] >= 8 or stone_pos[1] >= 8:
            if flag:
                k_pos[1] -= 1
                stone_pos[1] -= 1
            else:
                k_pos[1] -= 1

    elif com == 'RT': # 오른쪽 위 대각션으로
        flag = False
        k_pos[0] += 1
        k_pos[1] += 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0]+=1
            stone_pos[1]+=1

        if k_pos[0] >= 8 or stone_pos[0] >= 8 or k_pos[1] >= 8 or stone_pos[1] >= 8:
            if flag:
                k_pos[0]-=1
                k_pos[1]-=1
                stone_pos[0]-=1
                stone_pos[1]-=1
            else:
                k_pos[0] -= 1
                k_pos[1] -= 1
    elif com == 'LT': # 왼쪽 위 대각선으로
        flag = False
        k_pos[0] -= 1
        k_pos[1] += 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0] -= 1
            stone_pos[1] += 1

        if k_pos[0] < 0 or stone_pos[0] < 0 or k_pos[1] >= 8 or stone_pos[1] >= 8:
            if flag:
                k_pos[0] += 1
                k_pos[1] -= 1
                stone_pos[0] += 1
                stone_pos[1] -= 1
            else:
                k_pos[0] += 1
                k_pos[1] -= 1

    elif com == 'RB': # 오른쪽 아래 대각선으로
        flag = False
        k_pos[0] += 1
        k_pos[1] -= 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0] += 1
            stone_pos[1] -= 1

        if k_pos[0] >= 8 or stone_pos[0] >= 8 or k_pos[1] < 0 or stone_pos[1] < 0:
            if flag:
                k_pos[0] -= 1
                k_pos[1] += 1
                stone_pos[0] -= 1
                stone_pos[1] += 1
            else:
                k_pos[0] -= 1
                k_pos[1] += 1

    else: # 왼쪽 아래 대각선으로
        flag = False
        k_pos[0] -= 1
        k_pos[1] -= 1

        if k_pos[0] == stone_pos[0] and k_pos[1] == stone_pos[1]:
            flag = True
            stone_pos[0] -= 1
            stone_pos[1] -= 1

        if k_pos[0] < 0 or stone_pos[0] < 0 or k_pos[1] < 0 or stone_pos[1] < 0:
            if flag:
                k_pos[0] += 1
                k_pos[1] += 1
                stone_pos[0] += 1
                stone_pos[1] += 1
            else:
                k_pos[0] += 1
                k_pos[1] += 1

tmp1 = chr(k_pos[0]+ord('A'))
tmp2 = chr(stone_pos[0]+ord('A'))
print(f'{tmp1}{k_pos[1]+1}')
print(f'{tmp2}{stone_pos[1]+1}')