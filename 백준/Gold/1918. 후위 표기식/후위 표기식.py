import sys
input = sys.stdin.readline

infix_ary = list(input().rstrip())
result = ''
stack = []
for v in infix_ary:
    if v.isalpha():
        result += v
    else:
        if v == '(':
            stack.append(v)

        elif v == '*' or v == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                result += stack.pop()
            stack.append(v)

        elif v == '+' or v == '-':
            while stack and stack[-1] != '(':
                result += stack.pop()
            stack.append(v)

        elif v == ')':
            while stack and stack[-1] != '(':
                result += stack.pop()
            stack.pop()
while stack:
    result += stack.pop()
print(result)