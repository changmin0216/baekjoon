import sys
input = sys.stdin.readline

def recur(n, y, x):
    if(n == 3):
        arr[y][x] = '*'

        arr[y+1][x-1] = '*'
        arr[y+1][x+1] = '*'

        arr[y+2][x-2] = '*'
        arr[y+2][x-1] = '*'
        arr[y+2][x] = '*'
        arr[y+2][x+1] = '*'
        arr[y+2][x+2] = '*'
    else:
        recur(n//2, y, x)
        recur(n//2, y+n//2, x - n//2)
        recur(n//2, y+n//2, x + n//2)
    return

n = int(input())

arr = [[' ']*(2*n-1) for _ in range(n)]

recur(n, 0, n-1)

for i in arr:
    print(''.join(i))