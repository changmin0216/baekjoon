n = int(input())

arr = []
for _ in range(n):
    arr.append(input())

if n==1:
    print(1)
    exit(0)
len_ = len(arr[0])
for i in range(len_-1, -1, -1):

    set_ = set()
    for j in range(n):
        set_.add(arr[j][i:len_])

    if len(set_) == n:
        print(len_-i)
        break