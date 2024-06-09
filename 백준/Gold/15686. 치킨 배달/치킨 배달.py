import sys
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())

chicken = []
home = []
for k in range(n):
    temp = list(map(int, input().split()))
    for i in range(len(temp)):
        if temp[i] == 2:
            chicken.append([k, i])
        elif temp[i] == 1:
            home.append([k, i])

result = []
for i in range(1, m+1):
    for l in combinations(chicken, i):
        sum = 0
        for j in home:
            mina = sys.maxsize
            for i in range(len(l)):
                temp = abs(j[0]-l[i][0])+ abs(j[1]-l[i][1])
                if temp < mina:
                    mina = temp
            sum+=mina
        result.append(sum)
print(min(result))
