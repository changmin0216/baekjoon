import sys, heapq
input = sys.stdin.readline

## 1<=n<=1500
n = int(input())

max_heap = []

for _ in range(n):
    l = list(map(int, input().split()))
    if len(max_heap) == 0:
        for num in l:
            heapq.heappush(max_heap, num)
    else:
        for num in l:
            if max_heap[0] < num:
                heapq.heappush(max_heap, num)
                heapq.heappop(max_heap)

print(max_heap[0])
