import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
K = int(input())

graph = [[0 for _ in range(N+1)] for _ in range(N+1)]

for _ in range(K):
    y, x = map(int, input().split())
    graph[y][x] = 1 #사과위치

L = int(input())
direction = deque()
for _ in range(L):
    X, C = input().split()
    direction.append((int(X), C))

#동 남 서 북
dx = [1,0,-1,0]
dy = [0,1,0,-1]

snake = deque([(1,1)])

d = 0 #초기 방향
y, x = 1, 1
graph[y][x] = 2 #뱀의 초기위치
time = 0
while True:
    ny, nx = y + dy[d], x + dx[d]
    if ny<=0 or ny>N or nx<=0 or nx>N or (ny, nx) in snake:
        break
    if graph[ny][nx]!=1: #사과가 없으면
        a, b = snake.popleft() #몸길이 줄인다
        graph[a][b] = 0 #그 위치를 0으로
    y, x = ny, nx
    graph[y][x] = 2 #뱀이 위치한 곳
    snake.append((y, x))
    time+=1

    # 시간에 해당하는 방향전환 정보가 있을 경우
    if len(direction)!=0:
        if time == direction[0][0]:
            if direction[0][1] == 'D': #오른쪽으로 90
                d = (d + 1) % 4
            else:
                if d == 0:
                    d = 3
                else:
                    d -= 1
            direction.popleft()
print(time + 1)