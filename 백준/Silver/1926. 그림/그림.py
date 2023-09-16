import sys
input = sys.stdin.readline

n, m = map(int, input().split())

g = [list(map(int, input().split())) for _ in range(n)]

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
            if 0<=ny<n and 0<=nx<m:
                if g[ny][nx]==1:
                    g[ny][nx]=0
                    result+=1
                    q.append((ny,nx))
    
    return result


cnt=0
msize=0
for i in range(n):
    for j in range(m):
        if g[i][j] == 1:
            cnt+=1
            g[i][j] = 0
            msize = max(msize, bfs(i,j))

print(cnt)
print(msize)
