import sys
from operator import index

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr.sort()

print(arr[(n-1)//2])