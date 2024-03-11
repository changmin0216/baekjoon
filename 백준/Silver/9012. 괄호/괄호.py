import sys

T = int(input())
chk = False
for k in range(T):
    chk = False
    stack = []
    vps = list(input())
    for v in vps:
        if v == '(':
            stack.append(v)
        elif v == ')':
            if len(stack) == 0:
                chk = True
                continue
            else:
                stack.pop()
    if chk:
        print("NO")
    else:
        if len(stack) == 0:
            print("YES")
        else:
            print("NO")