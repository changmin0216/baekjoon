import sys
input = sys.stdin.readline

n = int(input())

students = []
for _ in range(n**2):
    students.append(list(map(int, input().split())))

sit = [[0] * n for _ in range(n)]

dy = [-1,1,0,0]
dx = [0,0,-1,1]

for student in students:

    c = []
    for i in range(n):
        for j in range(n):
            if sit[i][j] == 0:
                empty, prefer = 0, 0

                for k in range(4):
                    ny = i + dy[k]
                    nx = j + dx[k]

                    if 0<=ny<n and 0<=nx<n:
                        if sit[ny][nx] == 0:
                            empty+=1

                        if sit[ny][nx] in student[1:]:
                            prefer+=1

                c.append((i, j, empty, prefer))

    c.sort(key = lambda x:(-x[3], -x[2], x[0], x[1]))
    sit[c[0][0]][c[0][1]] = student[0]

answer = 0
for i in range(n):
    for j in range(n):
        sum_ = 0
        for student in students:
            if student[0] == sit[i][j]:

                for k in range(4):
                    ny = i + dy[k]
                    nx = j + dx[k]

                    if 0<=ny<n and 0<=nx<n:
                        if sit[ny][nx] in student[1:]:
                            sum_+=1
                break
        if sum_!=0:
            answer+=10**(sum_-1)
print(answer)