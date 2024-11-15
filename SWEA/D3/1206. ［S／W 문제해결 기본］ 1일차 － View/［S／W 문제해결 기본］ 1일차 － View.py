
for case in range(10):
    n = int(input())
    arr = list(map(int, input().split()))

    answer = 0
    for i in range(2, n-2):
        left_max = max(arr[i-1], arr[i-2])
        right_max = max(arr[i+1], arr[i+2])

        if arr[i] > left_max and arr[i] > right_max:
            answer += min(arr[i]-left_max, arr[i]-right_max)
    print(f'#{case+1} {answer}')
