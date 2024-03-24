import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    m, n, x, y = map(int, input().split())

    temp = x
    while temp <= m * n:
        if (temp - x) % m == 0 and (temp - y) % n == 0:
            print(temp)
            break
        temp += m
    else: # 만약 break 안했으면
        print(-1)
