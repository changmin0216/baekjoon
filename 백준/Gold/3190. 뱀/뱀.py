import sys
from collections import deque
input = sys.stdin.readline

n = int(input()) #보드의 크기
k = int(input()) #사과의 개수

board = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(k):
    a, b = map(int, input().split())
    board[a-1][b-1] = 1

l = int(input())

change_direction = deque()

for _ in range(l):
    change_direction.append(list(map(str, input().split())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

direction = 0

snake = deque()
snake.append([0,0])

time = 0
while True:

    ey, ex = snake[-1]

    ny, nx = ey + dy[direction], ex + dx[direction]

    if 0 > nx or nx >= n or 0 > ny or ny >= n:
        break

    if [ny, nx] in snake:
        break

    if board[ny][nx] == 1: ## 사과가 있으면
        board[ny][nx]=0
    else: ##사과가 없으면
        snake.popleft()

    snake.append([ny, nx])

    time+=1
    if change_direction:
        if str(time) == change_direction[0][0]:
            if change_direction[0][1] == 'D': ## 오른쪽으로 90도
                direction = (direction + 1)%4
            else: ## 왼쪽으로 90도
                direction = (direction - 1)
                if direction == -1:
                    direction = 3

            change_direction.popleft()

    # print(time-1,"초가 끝난 후 ")
    # print(snake)
    # print(direction)

print(time+1)