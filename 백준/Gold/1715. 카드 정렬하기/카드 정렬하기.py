import sys
input = sys.stdin.readline
import heapq

n = int(input())

cards = []

for _ in range(n):
    heapq.heappush(cards, int(input()))

answer = 0
while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    sum = a+b

    answer += sum
    heapq.heappush(cards, sum)

print(answer)