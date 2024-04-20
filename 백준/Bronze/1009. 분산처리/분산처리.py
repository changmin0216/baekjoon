import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    ary = []
    q=1
    while(1):
        temp = a**q
        if temp%10 not in ary:
            ary.append(temp%10)
        else:
            break
        q+=1
    index = (b%len(ary))-1
    if ary[index]==0:
        print(10)
    else:
        print(ary[index])