from collections import deque

for _ in range(10):
    case_num = int(input())

    arr = list(map(int, input().split()))
    q = deque(arr)

    while True:
        for i in range(1, 6):
            q.append(q.popleft() - i)
            if q[-1] <= 0:
                q[-1] = 0
                break
        else: # break 안하면
            continue
        break

    print(f'#{case_num} {" ".join(map(str, q))}')