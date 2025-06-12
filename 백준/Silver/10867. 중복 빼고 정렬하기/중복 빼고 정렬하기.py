n = int(input())
arr = list(map(int, input().split()))

arr.sort()
set_ = set()
for x in arr:
    set_.add(x)

print(' '.join(map(str, set_)))