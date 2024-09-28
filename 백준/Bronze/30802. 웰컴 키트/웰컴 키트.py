import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
t, p = map(int, input().split())

a = 0
for i in arr:
    if i==0:
        continue
    if i//t==0:
        a+=1
    else:
        if i%t==0:
            a+=i//t
        else:
            a+=i//t+1

print(a)
sum_ = sum(arr)
print(sum_//p, sum(arr)%p)