import sys
input = sys.stdin.readline
from collections import deque
N = int(input())

deck = deque()
for _ in range(N):
    cmd = list(input().rstrip().split())

    if cmd[0] == 'push_front':
        deck.appendleft(int(cmd[1]))
    elif cmd[0] == 'push_back':
        deck.append(int(cmd[1]))
    elif cmd[0] == 'pop_front':
        if deck:
            print(deck.popleft())
        else:
            print(-1)
    elif cmd[0] == 'pop_back':
        if deck:
            print(deck.pop())
        else:
            print(-1)
    elif cmd[0] == 'size':
        print(len(deck))
    elif cmd[0] == 'empty':
        if deck:
            print(0)
        else:
            print(1)
    elif cmd[0] == 'front':
        if deck:
            print(deck[0])
        else:
            print(-1)
    elif cmd[0] == 'back':
        if deck:
            print(deck[-1])
        else:
            print(-1)