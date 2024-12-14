## t<=20
## n<=100,000

import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())

    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))
    arr.sort(key=lambda x: x[0])
    top = 0
    result = 1

    for i in range(n):
        if arr[i][1] < arr[top][1]:
            top=i
            result+=1
    print(result)