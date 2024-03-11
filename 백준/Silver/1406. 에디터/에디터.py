import sys
input = sys.stdin.readline

stack1 = list(input().rstrip())
m = int(input())

stack2 = []

for _ in range(m):
    cmd = list(input().rstrip().split())
    if cmd[0] == 'P':
        stack1.append(cmd[1])
    elif cmd[0] == 'L' and stack1:
        stack2.append(stack1.pop())
    elif cmd[0] == 'D' and stack2:
        stack1.append(stack2.pop())
    elif cmd[0] == 'B' and stack1:
        stack1.pop()
result = stack1 + stack2[::-1]
print(''.join(result))

