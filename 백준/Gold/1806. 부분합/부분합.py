import sys
input = sys.stdin.readline

n, s = map(int, input().split())

ary = list(map(int, input().split()))

left = 0
right = 0
total = 0
min_len = int(1e9)

while True:
    if total >= s:
        min_len = min(min_len, right-left)
        total -= ary[left]
        left+=1

    elif total < s:
        if right == len(ary):
            break
        total += ary[right]
        right+=1

if min_len == int(1e9):
    print(0)
else:
    print(min_len)
