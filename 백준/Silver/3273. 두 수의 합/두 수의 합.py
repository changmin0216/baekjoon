import sys
input = sys.stdin.readline

n = int(input())
ary = list(map(int, input().split()))
x = int(input())

ary.sort()

left = 0
right = n-1
cnt = 0
while left < right:
    answer = ary[left] + ary[right]
    if answer == x:
        cnt+=1
        left+=1
    elif answer < x:
        left+=1
    else:
        right-=1
print(cnt)
