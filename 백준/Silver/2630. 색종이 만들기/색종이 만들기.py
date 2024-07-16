import sys
input = sys.stdin.readline

n = int(input())
paper = []

for _ in range(n):
    paper.append(list(map(int, input().split())))

white = 0
blue = 0
def check_same(partial):
    length = len(partial)
    temp = partial[0][0]
    for i in range(length):
        for j in range(length):
            if partial[i][j]!=temp:
                return False
    return True

def fold_paper(paper):
    global white, blue
    length = len(paper)//2

    tmp1 = []
    tmp2 = []
    tmp3 = []
    tmp4 = []

    for i in range(length):
        tmp1.append(paper[i][0:length])
        tmp2.append(paper[i][length:])
    for i in range(length, len(paper)):
        tmp3.append(paper[i][0:length])
        tmp4.append(paper[i][length:])

    if check_same(tmp1):
        if tmp1[0][0] == 0:
            white+=1
        else:
            blue+=1
    else:
        fold_paper(tmp1)

    if check_same(tmp2):
        if tmp2[0][0] == 0:
            white+=1
        else:
            blue+=1
    else:
        fold_paper(tmp2)

    if check_same(tmp3):
        if tmp3[0][0] == 0:
            white += 1
        else:
            blue += 1
    else:
        fold_paper(tmp3)

    if check_same(tmp4):
        if tmp4[0][0] == 0:
            white += 1
        else:
            blue += 1
    else:
        fold_paper(tmp4)

if check_same(paper):
    if paper[0][0] == 0:
        white+=1
    else:
        blue+=1
else:
    fold_paper(paper)
print(white)
print(blue)

