import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
op = list(map(int, input().split()))

tmp = []

o = ['+', '-', '*', '/']
for i in range(4):
    if op[i]!=0:
        for _ in range(op[i]):
            tmp.append(o[i])

result = []
for l in permutations(tmp, len(tmp)):
    answer = 0
    for i in range(len(l)):
        if i==0:
            if l[i] == '+':
                answer += arr[i]+arr[i+1]
            elif l[i] == '-':
                answer += arr[i] - arr[i + 1]
            elif l[i] == '*':
                answer += arr[i] * arr[i + 1]
            else:
                if arr[i] < 0 and arr[i+1] > 0:
                    answer += -(-arr[i] // arr[i+1])
                else:
                    answer += arr[i] // arr[i + 1]
        else:
            if l[i] == '+':
                answer += arr[i+1]
            elif l[i] == '-':
                answer -= arr[i+1]
            elif l[i] == '*':
                answer *= arr[i+1]
            else:
                if answer < 0 and arr[i+1] > 0:
                    answer = -(-answer // arr[i+1])
                else:
                    answer //= arr[i+1]
    result.append(answer)

print(max(result))
print(min(result))