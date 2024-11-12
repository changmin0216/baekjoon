
def recur(depth):
    global max_num
    if depth == r:
        tmp = int(''.join(map(str, arr)))
        max_num = max(max_num, tmp)
        return

    for i in range(len(arr)-1):
        for j in range(i+1, len(arr)):
            # if arr[i] <= arr[j]:
            arr[i], arr[j] = arr[j], arr[i]
            tmp = int(''.join(map(str, arr)))
            if (tmp, depth+1) not in visited:
                recur(depth+1)
                visited.append((tmp, depth+1))
            arr[i], arr[j] = arr[j], arr[i]

t = int(input())

for i in range(t):
    num, r = map(int, input().split())
    arr = list(map(int, str(num)))

    max_num = -1

    visited = []
    recur(0)
    print(f'#{i+1}', max_num)