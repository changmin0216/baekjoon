import sys
import math
input = sys.stdin.readline

x, y = map(int, input().split())

left = 0
right = x

if (y*100)//x >= 99:
    print(-1)
    exit()

while left <= right:
    mid = (left + right) // 2

    if ((y+mid)*100)//(x+mid) - (y*100)//x >= 1:
        right = mid-1
    else:
        left = mid+1

print(left)