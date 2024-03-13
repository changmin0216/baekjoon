import sys
input = sys.stdin.readline

ary = list(input().rstrip())
stack = []
cnt = 0
for i in range(len(ary)):
    if ary[i] == '(':
        stack.append(ary[i])
    else: #')'일때
        if ary[i-1] == '(':
            stack.pop()
            cnt+=len(stack)
        else:
            stack.pop()
            cnt+=1
print(cnt)