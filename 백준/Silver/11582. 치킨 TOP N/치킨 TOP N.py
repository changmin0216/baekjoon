import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
k = int(input())

mul = 2
while n > k:
    for i in range(0, len(arr), mul):
        arr[i:i+mul] = sorted(arr[i:i+mul])
    n = n//2
    mul*=2
print(' '.join(map(str, arr)))