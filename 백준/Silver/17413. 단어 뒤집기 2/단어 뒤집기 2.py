import sys
from collections import deque
input = sys.stdin.readline

stack = []
q = deque()

s = input().rstrip()

answer = ''
is_q = False
for c in s:
    if c == '<':
        if stack:
            while stack:
                answer+=stack.pop()
        q.append('<')
        is_q = True
        continue
    elif c== '>':
        while q:
            answer+=q.popleft()
        answer+='>'
        is_q = False
        continue
    elif c== ' ' and not is_q:
        while stack:
            answer+=stack.pop()
        answer+=' '
        continue
    elif is_q:
        q.append(c)
        continue
    else:
        stack.append(c)
if stack:
    while stack:
        answer+=stack.pop()
print(answer)