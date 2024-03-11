import sys
input = sys.stdin.readline
T = int(input())
chk = False
for k in range(T):
    chk = False
    stack = []
    vps = list(input().rstrip())
    for v in vps:
        if v == '(':
            stack.append(v)
        else:
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