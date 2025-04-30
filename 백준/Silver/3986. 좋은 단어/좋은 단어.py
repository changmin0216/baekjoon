import sys
input = sys.stdin.readline

n = int(input())

result = 0
for _ in range(n):
    word = input().rstrip()

    stack = []
    for c in word:
        if stack and stack[-1] == c:
            stack.pop()
        else:
            stack.append(c)

    if len(stack) == 0:
        result+=1

print(result)