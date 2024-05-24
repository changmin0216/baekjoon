import sys
input = sys.stdin.readline

n = int(input())

student = []

for _ in range(n):
    a = list(input().split())
    l = []
    for i in range(4):
        if i==0:
            l.append(a[i])
        else:
            l.append(int(a[i]))
    student.append(l)

student.sort(key= lambda x: (-x[1], x[2], -x[3], x[0]))

for v in student: print(v[0])