import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

m, n, k = map(int, input().split())

map_ = [[0 for _ in range(n)] for _ in range(m)]
# visited = [[False for _ in range(n)] for _ in range(m)]

for _ in range(k):
    # 0 2 4 4
    x1, y1, x2, y2 = map(int, input().split()) # 왼쪽 아래 꼭짓점, 오른쪽 위 꼭짓점
    for i in range(y1, y2):
        for j in range(x1, x2):
            map_[i][j] = 1

dx = [0,0,-1,1]
dy = [-1,1,0,0,]
def dfs(y, x):
    global area
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if 0<=ny<m and 0<=nx<n:
            if map_[ny][nx] == 0:
                map_[ny][nx] = 1
                area+=1
                dfs(ny, nx)
    return

cnt = 0
result = []
for i in range(m):
    for j in range(n):
        if map_[i][j] == 0:
            map_[i][j] = 1
            cnt+=1
            area = 1
            dfs(i, j)
            result.append(area)
result.sort()
print(cnt)
print(*result)