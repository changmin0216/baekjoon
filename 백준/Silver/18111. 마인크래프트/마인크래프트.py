import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())

map_ = []
for _ in range(n):
    map_.append(list(map(int, input().split())))

ans = int(1e9)
height = 0
for h in range(257):
    use_block = 0
    take_block = 0
    for x in range(n):
        for y in range(m):
            if map_[x][y] > h:
                take_block += map_[x][y] - h
            else:
                use_block += h - map_[x][y]

    if use_block > take_block + b:
        continue

    count = take_block * 2 + use_block

    if count <= ans:
        ans = count
        height = h

print(ans, height)