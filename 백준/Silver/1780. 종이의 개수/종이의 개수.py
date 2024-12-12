import sys
input = sys.stdin.readline

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

def check(y, x, size):
    if size == 1:
        return True
    else:
        tmp = graph[y][x]
        for i in range(y, y+size):
            for j in range(x, x+size):
                if tmp!=graph[i][j]:
                    return False
        return True

cnt = [0,0,0]
def solve(y, x, size):
    # print(y, x, size)

    if check(y,x,size):
        cnt[graph[y][x]]+=1
        return
    else:
        solve(y, x, size//3)
        solve(y, x+size//3, size//3)
        solve(y, x+size//3+size//3, size//3)

        solve(y+size//3, x, size // 3)
        solve(y+size//3, x + size // 3, size // 3)
        solve(y+size//3, x + size // 3 + size // 3, size // 3)

        solve(y + size // 3 + size // 3, x, size // 3)
        solve(y + size // 3 + size // 3, x + size // 3, size // 3)
        solve(y + size // 3 + size // 3, x + size // 3 + size // 3, size // 3)
        return
solve(0,0,n)
print(cnt[-1])
print(cnt[0])
print(cnt[1])