import sys
input = sys.stdin.readline

n = int(input())

maps = []

for _ in range(n):
    maps.append(list(map(str, input().rstrip())))

def check(maps):
    max_cnt = 1
    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if maps[i][j] == maps[i][j-1]:
                cnt+=1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)

        cnt = 1
        for j in range(1, n):
            if maps[j][i] == maps[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
    return max_cnt

result = 0
for i in range(n):
    for j in range(n):
        if j+1<n:
            maps[i][j], maps[i][j+1] = maps[i][j+1], maps[i][j]
            cnt = check(maps)
            result = max(result, cnt)
            maps[i][j+1], maps[i][j] = maps[i][j], maps[i][j+1]
        if i+1<n:
            maps[i][j], maps[i+1][j] = maps[i+1][j], maps[i][j]
            cnt = check(maps)
            result = max(result, cnt)
            maps[i + 1][j], maps[i][j] = maps[i][j], maps[i+1][j]

print(result)