import sys
input = sys.stdin.readline

n = int(input())

if n==0:
    print(0)
else:
    arr = []
    for _ in range(n):
        arr.append(int(input()))
    arr.sort()

    k = round((n * 0.15)+10e-10)
    print(round(sum(arr[k:n-k])/(n-2*k)+10e-10))