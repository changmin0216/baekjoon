import sys
input = sys.stdin.readline

s = set()

m = int(input())

for _ in range(m):
    com = list(map(str, input().split()))

    if com[0] == 'add':
        s.add(int(com[1]))
    elif com[0] == 'remove':
        s.discard(int(com[1]))
    elif com[0] == 'check':
        if int(com[1]) in s:
            print(1)
        else:
            print(0)
    elif com[0] == 'toggle':
        if int(com[1]) in s:
            s.discard(int(com[1]))
        else:
            s.add(int(com[1]))
    elif com[0] == 'all':
        s = set([i for i in range(1, 21)])
    elif com[0] == 'empty':
        s = set()