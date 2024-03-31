import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)
#상하좌우
dx = [0,0,-1,1,-1,1,-1,1]
dy = [-1,1,0,0,-1,-1,1,1]
def dfs(y, x):

    for i in range(8):
        ny, nx = y + dy[i], x + dx[i]
        if 0<=ny<h and 0<=nx<w:
            if not visited[ny][nx] and maps[ny][nx]==1:
                visited[ny][nx] = True
                dfs(ny, nx)


while 1:
    w, h = map(int, input().split())
    if w==0 and h==0:
        break
    maps = []
    visited = [[False for _ in range(w)] for _ in range(h)]
    for _ in range(h):
        maps.append(list(map(int, input().split())))

    result=0
    for i in range(h):
        for j in range(w):
            if maps[i][j]==1 and not visited[i][j]:
                visited[i][j] = True
                dfs(i, j)
                result+=1
    print(result)