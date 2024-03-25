import sys
input = sys.stdin.readline
from itertools import permutations, combinations

while 1:
    com = list(map(int, input().split()))
    if com[0] == 0:
        break
    arr = []
    for i in range(1, com[0]+1):
        arr.append(com[i])

    for v in combinations(arr, 6):
        print(*v)
    print()