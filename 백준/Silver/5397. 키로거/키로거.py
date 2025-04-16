import sys
input = sys.stdin.readline


###################
t = int(input())

for _ in range(t):
    L = input().rstrip()

    l_stack = []
    r_stack = []

    for c in L:
        if c == '-':
            if l_stack:
                l_stack.pop()
        elif c == '<':
            if l_stack:
                r_stack.append(l_stack.pop())
        elif c == '>':
            if r_stack:
                l_stack.append(r_stack.pop())
        else:
            l_stack.append(c)
    print(''.join(l_stack), end='')
    print(''.join(r_stack[::-1]))