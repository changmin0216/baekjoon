for _ in range(10):
    case = int(input())

    arr = []

    answer = []
    cross_left = 0
    cross_right = 0
    for i in range(100):
        tmp = list(map(int, input().split()))
        answer.append(sum(tmp))

        cross_left+=tmp[i]
        cross_right+=tmp[99-i]

        arr.append(tmp)

    answer.append(cross_left)
    answer.append(cross_right)

    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp+=arr[j][i]
        answer.append(tmp)

    print(f'#{case} {max(answer)}')