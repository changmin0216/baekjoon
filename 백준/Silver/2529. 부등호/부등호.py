import sys
input = sys.stdin.readline
from itertools import combinations, permutations

k = int(input())

sign = list(map(str, input().split()))

nums = list(i for i in range(10))
result = []
for v in permutations(nums, k+1):
    temp = ''
    temp+=str(v[0])
    for i in range(1, len(v)):

        if sign[i-1] == '>':
            if v[i-1] > v[i]:
                temp+=str(v[i])
            else:
                break
        else:
            if v[i-1] < v[i]:
                temp+=str(v[i])
            else:
                break
    else:
        result.append(temp)

test = list(map(int, result))
max_ = max(test)
min_ = min(test)

max_i = 0
min_i = 0
for i in range(len(result)):
    if int(result[i]) == max_:
        max_i = i
    elif int(result[i]) == min_:
        min_i = i

print(result[max_i])
print(result[min_i])