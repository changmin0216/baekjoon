import sys
input = sys.stdin.readline

ary = list(map(int, input().rstrip()))

cnt_zero = 0
cnt_one = 0

if ary[0]==1:
    cnt_one += 1
else:
    cnt_zero += 1

for i in range(len(ary)-1):
    if ary[i] != ary[i+1]:
        if ary[i+1] == 1:
            cnt_one += 1
        else:
            cnt_zero += 1

print(min(cnt_zero,cnt_one))