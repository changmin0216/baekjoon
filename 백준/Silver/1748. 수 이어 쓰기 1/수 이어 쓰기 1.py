import sys
input = sys.stdin.readline

n = int(input())

num = str(n)

result = 0
cnt = 1
while 1:
    if cnt == len(num):
        temp = 0
        for i in range(cnt-1):
            temp += 9*(10**i)
        result += cnt*(n-temp)
        break
    else:
        result += cnt*9*(10**(cnt-1))
        cnt+=1
print(result)