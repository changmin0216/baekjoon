import sys
from collections import deque
 
def bfs(cnt, x):
    queue = deque()
    queue.append((cnt, x))	#(이동횟수, 좌표x)
    while queue:
        cnt, x = queue.popleft()
        dx = [x-b, x+f]	#뒤로 이동한 좌표, 앞으로 이동한 좌표
        for nx in dx:
            if nx >= n or nx < 0:	#벽에 부딪혔을 때 건너뛰기
                continue
            if game[nx] == "p":	#경찰서 피해가기
                continue
            if game[nx] == "h":	#집에 도착하면 이동횟수 리턴
                return cnt
            game[nx] = "p"	#방문한 좌표는 "p"로 설정해 다시 방문하지 않게 한다.
            queue.append((cnt+1, nx))	#(이동횟수+1, 새로운 좌표)
    return "BUG FOUND"	#집에 도착하지 못한 경우
    
n, s, d, f, b, k = map(int, sys.stdin.readline().split())
game = ["t"] * n
 
#털린 금은방
game[s-1] = "g"
 
#도둑의 집
game[d-1] = "h"
 
temp = []
#경찰서 배치
temp = list(map(int, sys.stdin.readline().split()))
for i in temp:
    game[i-1] = "p"
 
cnt = 1
for i in range(n):
    if game[i] == "g":	#금은방에서부터 출발
        print(bfs(cnt, i))