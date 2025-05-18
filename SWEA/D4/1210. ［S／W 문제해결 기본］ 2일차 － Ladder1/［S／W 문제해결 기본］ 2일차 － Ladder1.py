def solution(index):
    rotate = 1

    y = 0
    x = index

    while 0<=y<100 and 0<=x<100:
        if graph[y][x] == 2:
            return True

        if rotate == 1:
            for i in (2, 3):
                ny, nx = y + dy[i], x+dx[i]

                if 0<=ny<100 and 0<=nx<100:
                    if graph[ny][nx] == 1:
                        rotate = i
                        y = ny
                        x = nx
                        break
            else: ## 좌우로 못가면
                y += dy[rotate]
                x += dx[rotate]

        else: ## 왼쪽
            flag = False
            ny = y + dy[1]
            nx = x + dx[1]

            if 0 <= ny < 100 and 0 <= nx < 100:
                if graph[ny][nx] == 1:
                    rotate = 1
                    y = ny
                    x = nx
                    flag = True

            if not flag:
                y += dy[rotate]
                x += dx[rotate]

    return False
dy = [-1,1,0,0]
dx = [0,0,-1,1]
for _ in range(10):
    case = int(input())
    
    
    graph = []
    for _ in range(100):
        graph.append(list(map(int, input().split())))

    for i in range(100):
        if graph[0][i] == 1:
            if solution(i):
                print(f'#{case} {i}')
                break