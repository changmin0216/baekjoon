for case in range(10):
    n = int(input())
    h = list(map(int, input().split()))

    answer = 0
    for i in range(2, n-2):
        max_height = max(h[i-2], h[i-1], h[i+1], h[i+2])
        if max_height < h[i]:
            answer+=h[i]-max_height
    print(f'#{case+1} {answer}')