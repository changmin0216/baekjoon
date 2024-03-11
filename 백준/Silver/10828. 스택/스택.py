import sys
input = sys.stdin.readline
N = int(input())

stack = []
for _ in range(N):
    l = list(input().split())
    if l[0] == 'push':
        stack.append(l[1])
    elif l[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            pop_num = stack.pop()
            print(pop_num)
    elif l[0] == 'size':
        print(len(stack))
    elif l[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif l[0] == 'top':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
