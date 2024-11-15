# 1859번
# n<=10^6

t = int(input())

for i in range(t):
    n = int(input())

    arr = list(map(int, input().split()))

    sum = 0
    while len(arr) >= 1:
        max_val = max(arr)
        max_index = arr.index(max_val) # max_val의 첫번째 index

        for j in range(max_index, -1, -1):
            sum+=max_val - arr[j]

        arr = arr[max_index+1::]
    print(f'#{i+1} {sum}')