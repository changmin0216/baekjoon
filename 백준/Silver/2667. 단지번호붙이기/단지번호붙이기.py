import sys
input = sys.stdin.readline

n=int(input())

g = [list(map(int, input().strip())) for _ in range(n)]

dx=[1,-1,0,0]
dy=[0,0,-1,1]

def bfs(y_,x_):
    result = 1
    y, x = y_, x_
    q = [(y,x)]
    while q:
        ey, ex = q.pop()
        for k in range(4):
            ny = ey+dy[k]
            nx = ex+dx[k]
            if 0<=ny<n and 0<=nx<n:
                if g[ny][nx]==1:
                    g[ny][nx]=0
                    result+=1
                    q.append((ny,nx))
    
    return result


cnt=0
msize=[]
for i in range(n):
    for j in range(n):
        if g[i][j] == 1:
            cnt+=1
            g[i][j] = 0
            msize.append(bfs(i,j))

msize.sort()

print(cnt)
for i  in range(cnt):
    print(msize[i])
