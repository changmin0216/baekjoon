import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)
# min = sys.maxsize
sum = 0
for i in range(n):
    sum+=(A[i]*B[i])
print(sum)
# for l in permutations(A, len(A)):
#     sum = 0
#     for i in range(len(A)):
#         sum+=
#
#     if sum<min:
#         min = sum
# print(min)