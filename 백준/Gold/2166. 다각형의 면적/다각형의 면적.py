import sys
input = sys.stdin.readline

n = int(input())

cor = []
for i in range(n):
    cor.append(list(map(int, input().split())))
cor.append(cor[0])

result = 0
for i in range(n):
    result += (cor[i][0]*cor[i+1][1] - cor[i+1][0]*cor[i][1])
print(round(abs(result)/2, 1))