import sys
import heapq
input = sys.stdin.readline

n = int(input())

q = []
for _ in range(n):
    com = int(input())

    if com!=0:
        if com < 0:
            heapq.heappush(q, [-com, 'minus'])
        else:
            heapq.heappush(q, [com, 'plus'])
    else:
        if q:
            num, signed = heapq.heappop(q)
            if signed=='minus':
                print(-num)
            else:
                print(num)
        else:
            print(0)