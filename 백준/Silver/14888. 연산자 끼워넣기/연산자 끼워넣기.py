import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
op = list(map(int, input().split()))

op_r = []
for i in range(4):
    if i==0:
        for _ in range(op[i]):
            op_r.append('+')
    elif i==1:
        for _ in range(op[i]):
            op_r.append('-')

    elif i==2:
        for _ in range(op[i]):
            op_r.append('*')

    else:
        for _ in range(op[i]):
            op_r.append('/')

result = []
for l in permutations(op_r, len(op_r)):
    tmp = arr[0]
    for i in range(n-1):
        if l[i] == '+':
            tmp+=arr[i+1]
        elif l[i] == '-':
            tmp-=arr[i+1]
        elif l[i] == '*':
            tmp*=arr[i+1]
        else:
            if tmp<0 and arr[i+1]>0:
                tmp = -(-tmp//arr[i+1])
            else:
                tmp = tmp//arr[i+1]
    result.append(tmp)

print(max(result))
print(min(result))