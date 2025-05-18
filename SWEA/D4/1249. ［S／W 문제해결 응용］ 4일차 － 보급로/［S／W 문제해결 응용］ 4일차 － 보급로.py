from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def bfs():
    q = deque()
    q.append((0, 0))

    dp = [[-1] * n for _ in range(n)]
    dp[0][0] = 0

    while q:
        ey, ex = q.popleft()

        for i in range(4):
            ny, nx = ey + dy[i], ex + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if dp[ny][nx] == -1:  ##아직 방문 X
                    dp[ny][nx] = dp[ey][ex] + graph[ny][nx]
                    q.append((ny, nx))
                else:
                    if dp[ny][nx] > dp[ey][ex] + graph[ny][nx]:
                        dp[ny][nx] = dp[ey][ex] + graph[ny][nx]
                        q.append((ny, nx))
    return dp[n - 1][n - 1]

########################
t = int(input())

for case in range(1, t + 1):
    n = int(input())

    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().rstrip())))

    print(f'#{case} {bfs()}')