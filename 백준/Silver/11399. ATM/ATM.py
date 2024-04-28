import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr.sort()

sum=0
result=0
for v in arr:
    sum+=v
    result+=sum

print(result)