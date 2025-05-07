import sys, heapq
input = sys.stdin.readline

## 1<=n<=1500
n = int(input())

heap = []

for _ in range(n):
    l = list(map(int, input().split()))
    if len(heap) == 0:
        for num in l:
            heapq.heappush(heap, num)
    else:
        for num in l:
            if heap[0] < num:
                heapq.heappush(heap, num)
                heapq.heappop(heap)

print(heap[0])