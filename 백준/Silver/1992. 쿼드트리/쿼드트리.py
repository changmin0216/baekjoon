import sys
input = sys.stdin.readline

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

def recur(y, x, n):
    tmp = graph[y][x]
    check = True
    for i in range(y, y+n):
        for j in range(x, x+n):
            if graph[i][j] != tmp:
                tmp = -1
                break
    if tmp==-1:
        print('(', end='')

        n = n//2
        recur(y, x, n)
        recur(y, x+n, n)
        recur(y+n, x, n)
        recur(y+n, x+n, n)

        print(')', end='')

    elif tmp == 1:
        print(1, end='')
    else:
        print(0, end='')
recur(0, 0, n)
