import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

arr = list(map(int, str(n)))

def bfs():
    max_num = -1
    q = deque()
    q.append((n, 0))

    visited = set()
    visited.add((n,0))
    while q:
        num, depth = q.popleft()

        if depth == k:
            max_num = max(max_num, num)
            continue
        num_arr = list(str(num))
        for i in range(len(num_arr)-1):
            for j in range(i+1, len(num_arr)):
                if i == 0 and num_arr[j] == '0':
                    continue
                num_arr[i], num_arr[j] = num_arr[j], num_arr[i]
                tmp = int(''.join(map(str, num_arr)))
                if (tmp, depth+1) not in visited:
                    q.append((tmp, depth+1))
                    visited.add((tmp, depth+1))
                num_arr[i], num_arr[j] = num_arr[j], num_arr[i]
    return max_num

# if len(arr) == 1:
#     print(1)
#     exit(0)

max_num = bfs()

if max_num == -1:
    print(-1)
else:
    print(max_num)