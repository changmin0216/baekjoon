import sys
from collections import deque
input = sys.stdin.readline

A, B = input().rstrip().split()


if len(A)==len(B):
    answer = 0
    for i in range(len(A)):
        if A[i]!=B[i]:
            answer+=1
    print(answer)
    exit(0)

result = []
for i in range(len(B)-len(A)+1):
    tmp = 0
    for j in range(len(A)):
        # print(A, B[i:i+len(A)])
        if A[j]!=B[i:i+len(A)][j]:
            tmp+=1
    result.append(tmp)
print(min(result))