import sys
input = sys.stdin.readline

ary = list(map(int, input().rstrip()))

cnt_zero = 0
cnt_one = 0

flag = False
for v in ary:
    if v==0 and flag==False:
        cnt_zero+=1
        flag = True

    elif v==1:
        flag = False

flag = False
for v in ary:
    if v==1 and flag==False:
        cnt_one+=1
        flag = True

    elif v==0:
        flag = False

print(min(cnt_zero,cnt_one))