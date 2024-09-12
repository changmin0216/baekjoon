import sys
from collections import deque
input = sys.stdin.readline

def bfs(y, x):
    q = deque()
    q.append((y, x, 1, False))  # (y좌표, x좌표, 이동거리, 벽 부순 여부)

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    # 3차원 visited 배열 생성. visited[y][x][0]은 벽을 부수지 않은 상태, visited[y][x][1]은 벽을 부순 상태
    visited = [[[False] * 2 for _ in range(m)] for _ in range(n)]
    visited[y][x][0] = True  # 시작점에서 벽을 부수지 않은 상태로 방문

    while q:
        ey, ex, cost, flag = q.popleft()

        # 도착점에 도달하면 이동거리 반환
        if ey == n - 1 and ex == m - 1:
            return cost

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0 <= ny < n and 0 <= nx < m:
                if graph[ny][nx] == 0:  # 벽이 아닌 경우
                    if not visited[ny][nx][flag]:  # 해당 상태로 방문한 적이 없으면
                        visited[ny][nx][flag] = True
                        q.append((ny, nx, cost + 1, flag))

                elif graph[ny][nx] == 1 and not flag:  # 벽이지만 아직 부수지 않은 경우
                    if not visited[ny][nx][1]:  # 벽을 부순 상태로 방문한 적이 없으면
                        visited[ny][nx][1] = True
                        q.append((ny, nx, cost + 1, True))

    return -1  # 도착할 수 없는 경우

n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]

result = bfs(0, 0)

print(result)
