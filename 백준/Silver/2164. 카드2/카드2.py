# import sys
# input = sys.stdin.readline
# 
# n = int(input())
# 
# arr = [i for i in range(1, n+1)]
# while len(arr)!=1:
#     arr.pop(0)
# 
#     arr.append(arr.pop(0))
# 
# print(arr[0])
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

arr = deque()
for i in range(1, n+1):
    arr.append(i)
while len(arr)!=1:
    arr.popleft()

    arr.append(arr.popleft())

print(arr[0])