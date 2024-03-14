import sys
input = sys.stdin.readline
from collections import Counter
n = int(input())
ary = list(input().rstrip())

operator = ['+','-','*','/']

num = []
for _ in range(n):
    num.append(int(input()))

stack = []
for i in range(len(ary)):
    if ary[i] not in operator: #나는 숫자
        stack.append(num[ord(ary[i])-ord('A')])
    else: #나는 연산자
        y = stack.pop()
        x = stack.pop()
        if ary[i] == '+':
            r = x + y
        elif ary[i] == '-':
            r = x - y
        elif ary[i] == '*':
            r = x * y
        else:
            r = x / y
        stack.append(r)
print(f'{stack[0]:.2f}')



