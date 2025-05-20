dy = [-1,1,0,0]
dx = [0,0,-1,1]
def dfs(y, x):
    global flag
    if graph[y][x] == 3:
        flag = True
        return

    visited[y][x] = True

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0<=ny<16 and 0<=nx<16:
            if not visited[ny][nx] and graph[ny][nx] != 1:
                dfs(ny, nx)

    return
##########################
for _ in range(10):
    case = int(input())

    graph = []
    for _ in range(16):
        graph.append(list(map(int, input())))

    visited = [[False] * 16 for _ in range(16)]
    flag = False
    answer = 0
    for i in range(16):
        for j in range(16):
            if graph[i][j] == 2:
                dfs(i, j)
    if flag:
        answer = 1

    print(f'#{case} {answer}')