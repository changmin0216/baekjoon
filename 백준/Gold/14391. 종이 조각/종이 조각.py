import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = [list(map(int, input().rstrip())) for _ in range(n)]
result = []

for i in range(1<<(n*m)):
    total_sum = 0
    for row in range(n):
        row_sum = 0
        for col in range(m):
            idx = row*m + col
            if i & (1<<idx) != 0:
                row_sum = row_sum*10 + maps[row][col]
            else:
                total_sum+=row_sum
                row_sum = 0
        total_sum+=row_sum

    for col in range(m):
        col_sum = 0
        for row in range(n):
            idx = row*m + col
            if i & (1<<idx) == 0:
                col_sum = col_sum*10 + maps[row][col]
            else:
                total_sum+=col_sum
                col_sum = 0
        total_sum+=col_sum

    result.append(total_sum)
print(max(result))