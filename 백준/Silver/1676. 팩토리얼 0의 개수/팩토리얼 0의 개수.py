import sys
input = sys.stdin.readline

n = int(input())

if n == 0:
    print(0)
else:
    result=1
    for i in range(2, n+1):
        result*=i
    temp = result
    cnt=0
    while True:
        if temp%10 == 0:
            cnt+=1
            temp = temp // 10
        else:
            break
    print(cnt)