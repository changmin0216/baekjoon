import sys
input = sys.stdin.readline

n = int(input()) # 스위치의 개수
status = [-1]
tmp = list(map(int, input().split()))
for x in tmp:
    status.append(x)

k = int(input()) # 학생 수

students = []
for _ in range(k):
    students.append(list(map(int, input().split())))

for gender, x in students:
    if gender==1: ## 남학생이면
        for i in range(x, n+1, x):
            if status[i]==1:
                status[i] = 0
            else:
                status[i] = 1

    else:
        length = min(n-x+1, x)
        for i in range(1, length):
            if status[x+i] == status[x-i]:
                continue
            else: #만약 다르면
                for j in range(x-i+1, x+i):
                    if status[j] == 0:
                        status[j] = 1
                    else:
                        status[j] = 0
                break
        else:
            for j in range(x-length+1, x+length):
                if status[j] == 0:
                    status[j] = 1
                else:
                    status[j] = 0
    # print(status)

for i in range(1, n+1):
    print(status[i], end=' ')

    if i%20==0:
        print()