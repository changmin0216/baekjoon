import sys
input = sys.stdin.readline

while True:
    arr = list(map(int, input().split()))
    if arr.count(0) == 3:
        exit(0)
    arr.sort()
    if arr[2]**2 == arr[1]**2 + arr[0]**2:
        print("right")
    else:
        print("wrong")
