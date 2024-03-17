import sys
input = sys.stdin.readline

a, b = map(int, input().split())
m = int(input())

ary = list(map(int, input().split()))

temp = 1
result_ten = []

for i in range(len(ary)-1, -1, -1):
    result_ten.append(ary[i] * temp)
    temp*=a

ten = sum(result_ten)

result = []
while ten!=0:
    remain = ten%b
    result.append(remain)
    ten = ten // b
result.reverse()
print(*result)