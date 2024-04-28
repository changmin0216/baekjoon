import sys
input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

arr.sort(key=lambda x:(x[1], x[0]))

answer = 0
com_end = 0
for start, end in arr:
    if com_end <= start:
        answer += 1
        com_end = end

print(answer)