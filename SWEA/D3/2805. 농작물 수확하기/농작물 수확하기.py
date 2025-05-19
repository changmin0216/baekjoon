t = int(input())

for case in range(t):
    n = int(input())

    graph = []
    for _ in range(n):
        graph.append(list(map(int, input())))

    answer = 0
    idx_left = n//2
    idx_right = n//2 + 1
    for i in range(n):
        if i<n//2:
            # for j in range(idx_left, idx_right):
            #     print(graph[j])
            #     answer+=graph[j]

            answer+=sum(graph[i][idx_left:idx_right])
            idx_left-=1
            idx_right+=1
        else:
            answer += sum(graph[i][idx_left:idx_right])
            # for j in range(idx_left, idx_right):
            #     print(graph[j])
            # 
            #     answer+=graph[j]
            idx_left += 1
            idx_right -= 1
    print(f'#{case+1} {answer}')