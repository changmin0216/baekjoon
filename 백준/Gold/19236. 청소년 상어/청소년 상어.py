from copy import deepcopy

graph = [[] for _ in range(4)]

for i in range(4):
    tmp = list(map(int, input().split()))

    for j in range(0, len(tmp), 2):
        graph[i].append([tmp[j], tmp[j+1]-1])

# 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
result = 0
def dfs(s_y, s_x, score, graph):
    global result

    num, s_d = graph[s_y][s_x]
    score+=num
    result = max(result, score)

    graph[s_y][s_x][0] = 0

    ## 물고기 이동
    for num in range(1, 17):
        f_y, f_x = -1, -1
        for i in range(4):
            for j in range(4):
                if graph[i][j][0] == num:
                    f_y, f_x = i, j
                    break

        if f_y==-1 and f_x==-1:
            continue

        rotate = graph[f_y][f_x][1]
        for i in range(8):
            d = (rotate+i) % 8

            ny, nx = f_y + dy[d], f_x + dx[d]

            if 0<=ny<4 and 0<=nx<4:
                if ny != s_y or nx != s_x:
                    graph[f_y][f_x][1] = d
                    graph[f_y][f_x], graph[ny][nx] = graph[ny][nx], graph[f_y][f_x]
                    break

    ## 상어 이동
    for i in range(1, 4):
        ny, nx = s_y + dy[s_d]*i, s_x + dx[s_d]*i
        if 0<=ny<4 and 0<=nx<4:
            if graph[ny][nx][0]!=0:
                dfs(ny, nx, score, deepcopy(graph))

dfs(0,0,0, graph)
print(result)