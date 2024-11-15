t = int(input())

def recur(y, x, d):
    global num
    ny, nx = y + dy[d], x + dx[d]

    if 0<=ny<n and 0<=nx<n:
        if not visited[ny][nx]:
            num+=1
            graph[ny][nx] = num
            visited[ny][nx] = True
            if num == n**2:
                return
            recur(ny, nx, d)
        else: 
            d = (d + 1) % 4
            recur(y, x, d)
    else: 
        d = (d+1)%4
        recur(y, x, d)

dy = [0,1,0,-1]
dx = [1,0,-1,0]
for i in range(t):
    n = int(input())

    if n==1:
        print(f'#{i + 1}')
        print(1)
    else:
        graph = [[0] * n for _ in range(n)]
        visited = [[False] * n for _ in range(n)]
        num = 1

        graph[0][0] = num
        visited[0][0] = True
        d = 0
        recur(0,0,d)

        print(f'#{i+1}')
        for i in graph:
            print(' '.join(map(str, i)))