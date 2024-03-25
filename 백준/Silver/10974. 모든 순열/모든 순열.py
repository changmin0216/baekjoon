import sys
input = sys.stdin.readline
from itertools import permutations

n = int(input())
arr = [i for i in range(1, n+1)]
for v in permutations(arr, n):
    print(*v)