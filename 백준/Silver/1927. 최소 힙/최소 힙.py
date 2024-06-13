import sys
import heapq
input = sys.stdin.readline

n = int(input())

q = []

for _ in range(n):
    com = int(input())
    if com!=0:
        heapq.heappush(q, com)
    else:
        if q:
            print(heapq.heappop(q))
        else:
            print(0)

