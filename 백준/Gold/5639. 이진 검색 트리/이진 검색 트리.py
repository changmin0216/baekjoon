import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
arr = []

while True:
    try:
        n = int(input())
        arr.append(n)
    except:
        break

def recur(arr):
    if len(arr) == 0:
        return

    left, right = [], []
    root = arr[0]
    for i in range(1, len(arr)):
        if arr[i] > root:
            left = arr[1:i]
            right = arr[i:]
            break
    else:
        left = arr[1:]

    recur(left)
    recur(right)
    print(root)

recur(arr)