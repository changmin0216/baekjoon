import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
brk = list(map(int, input().split()))

result = abs(100-n)

for i in range(1000000):
    num = str(i)

    for j in num:
        if int(j) in brk:
            break
    else:
        result = min(result, abs(n-i)+len(num))

print(result)