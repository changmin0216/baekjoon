for i in range(10):
    k = int(input())

    arr = list(map(int, input().split()))
    for _ in range(k):
        max_index = arr.index(max(arr))
        min_index = arr.index(min(arr))

        if arr[max_index] - arr[min_index] <= 1:
            break
        arr[max_index] = arr[max_index]-1
        arr[min_index] = arr[min_index]+1
    print(f'#{i+1}', end=' ')
    print(max(arr) - min(arr))

