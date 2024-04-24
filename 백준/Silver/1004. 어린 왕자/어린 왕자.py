import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    cnt = 0
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    for _ in range(n):
        cx, cy, r = map(int, input().split())

        if (x1-cx)**2 + (y1-cy)**2 <= r**2 and (x2-cx)**2 + (y2-cy)**2 <= r**2:
            continue
        if (x1-cx)**2 + (y1-cy)**2 <= r**2:
            cnt+=1
        if (x2-cx)**2 + (y2-cy)**2 <= r**2:
            cnt+=1
    print(cnt)