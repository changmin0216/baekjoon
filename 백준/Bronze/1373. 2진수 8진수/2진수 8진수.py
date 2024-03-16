import sys
input = sys.stdin.readline

two = list(map(int, input().rstrip()))
result=''
for i in range(len(two)-1, -1, -3):
    cnt=1
    temp = 0
    for j in range(i, i-3, -1):
        if 0<=j<len(two):
            temp+=(two[j]*cnt)
            cnt*=2
    result+=str(temp)
print(''.join(reversed(result)))