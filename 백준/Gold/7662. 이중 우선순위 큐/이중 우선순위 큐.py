import sys
import heapq
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    max_heap = []
    min_heap = []

    visited = [False] * 1_000_000
    k = int(input())

    for i in range(k):
        com, val = map(str, input().split())
        if com == 'I':
            heapq.heappush(min_heap, (int(val), i))

            heapq.heappush(max_heap, (-int(val), i))

        else:
            if val == '1': #최댓값 삭제
                if max_heap:
                    visited[heapq.heappop(max_heap)[1]] = True
            else:
                if min_heap:
                    visited[heapq.heappop(min_heap)[1]] = True


        ## 다음 제거 대상이 될 인덱스에 있는 원소가 이미 다른 쪽에서 지워진 원소면 제거
        while min_heap and visited[min_heap[0][1]]:
            heapq.heappop(min_heap)
        while max_heap and visited[max_heap[0][1]]:
            heapq.heappop(max_heap)

    if max_heap and min_heap:
        print(-max_heap[0][0], min_heap[0][0])
    else:
        print('EMPTY')