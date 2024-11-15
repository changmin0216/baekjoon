import sys
input = sys.stdin.readline

n, m = map(int, input().split())

min_l = min(n, m)

map_ = []
for _ in range(n):
    map_.append(list(map(int, input().rstrip())))

result = []
for i in range(n):
    for j in range(m):
        num = map_[i][j]

        for k in range(0, min_l):
            if i+k < n and j+k < m:
                if map_[i+k][j] == num and map_[i][j+k] == num and map_[i+k][j+k] == num:
                    result.append((k+1)**2)

print(max(result))