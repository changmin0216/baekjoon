import sys
input = sys.stdin.readline

n, a, b = map(int, input().split())

a-=1
b-=1

round = 1
answer = -1
flag = False
while n>0:
    # print(round)
    for i in range(0,n,2):
        if (i==a and i+1==b) or (i==b and i+1==a):
            answer = round
            flag = True
            break
        elif i==a or i+1==a:
            a = a//2
        elif i==b or i+1==b:
            b = b//2
    if flag:
        break
    else:
        if n%2==0:
            n = n//2
        else:
            n = n//2+1
        round+=1
        # n = n//2
        # round+=1
print(answer)