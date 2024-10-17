import sys
input = sys.stdin.readline

str_ = input().rstrip()
bomb_str = input().rstrip()

stack = []
bomb_str_len = len(bomb_str)

for i in range(len(str_)):
    stack.append(str_[i])
    if ''.join(stack[-bomb_str_len:]) == bomb_str:
        for _ in range(bomb_str_len):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')