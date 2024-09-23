import sys
input = sys.stdin.readline

n, m = map(int, input().split())

board = []

for _ in range(n):
    board.append(list(input().rstrip()))

visited = [[0] * m for _ in range(n)]

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def _dfs(y, x, past, visited):
    global _max
    _max = max(_max, visited[y][x])
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if 0 <= ny < n and 0 <= nx < m and visited[ny][nx]==0:
            if board[ny][nx] not in past:
                visited[ny][nx] = visited[y][x] + 1
                past.add(board[ny][nx])
                _dfs(ny, nx, past, visited)
                past.remove(board[ny][nx])
                visited[ny][nx] = 0

    return

visited[0][0] = 1
past = set([board[0][0]])
_max = -1

_dfs(0,0, past, visited)

print(_max)