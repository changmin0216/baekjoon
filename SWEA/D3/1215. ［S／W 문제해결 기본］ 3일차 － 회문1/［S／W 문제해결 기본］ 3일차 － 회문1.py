for case in range(1, 11):
    n = int(input())

    graph = []
    for _ in range(8):
        graph.append(list(input()))

    answer = 0
    for i in range(8):
        for j in range(0, 8-n+1):
            if graph[i][j:j+n] == graph[i][j:j+n][::-1]:
                answer+=1

    for i in range(8):
        for j in range(0, 8-n+1):
            tmp = []
            for k in range(n):
                tmp.append(graph[j+k][i])

            if tmp == tmp[::-1]:
                answer+=1

    print(f'#{case} {answer}')