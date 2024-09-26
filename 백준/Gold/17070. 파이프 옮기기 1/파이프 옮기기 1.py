import sys
input = sys.stdin.readline

n = int(input())
_map = []
for _ in range(n):
    _map.append(list(map(int, input().split())))
cache = {}
def dfs(y1, x1, y2, x2, d):
    cnt = 0
    if y2==n-1 and x2==n-1:
        return 1
    if (y2, x2, d) in cache:
        return cache[(y2, x2, d)]
    else:
        for i in direction[d-1]:
            ny1, nx1, ny2, nx2 = y1 + i[0][0], x1 + i[0][1], y2 + i[1][0], x2 + i[1][1]
            if ny2-ny1 == 1 and nx2-nx1 == 1: # 대각선
                if 0<=ny1<n and 0<=ny2<n and 0<=nx1<n and 0<=nx2<n:
                    if 0<=ny1+1<n and 0<=nx1+1<n:
                        if _map[ny1][nx1]!=1 and _map[ny2][nx2]!=1 and _map[ny1+1][nx1]!=1 and _map[ny1][nx1+1]!=1:
                            cnt+=dfs(ny1, nx1, ny2, nx2, 3)
            else:
                if 0 <= ny1 < n and 0 <= ny2 < n and 0 <= nx1 < n and 0 <= nx2 < n:
                    if _map[ny1][nx1] != 1 and _map[ny2][nx2] != 1:
                        if ny2-ny1 == 1:
                            cnt+=dfs(ny1, nx1, ny2, nx2, 2)
                        else:
                            cnt+=dfs(ny1, nx1, ny2, nx2, 1)

    cache[(y2, x2, d)] = cnt
    return cnt
# 가로, 세로, 대각선
direction = [
                [
                    [[0,1],[0,1]], [[0,1], [1,1]]
                ],
                [
                    [[1,0],[1,0]], [[1,0], [1,1]]
                ],
                [
                    [[1,1],[0,1]], [[1,1], [1,0]], [[1,1], [1,1]]
                ]
            ]
print(dfs(0,0,0,1,1))