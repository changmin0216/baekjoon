import sys
input = sys.stdin.readline

n, k = map(int, input().split())
order = list(map(int, input().split()))

arr = [i for i in range(1, n+1)]

answer = 0
for i in range(k):
    index = arr.index(order[i])
    if index==0:
        arr = arr[1::]

    elif index <= len(arr)//2:
        arr = arr[index:] + arr[:index]
        # print(arr)
        arr = arr[1::]
        answer+=index
        # print(answer, end=' ')
        # print(arr)

    else:
        arr = arr[index:] + arr[:index]
        arr = arr[1::]
        answer+=len(arr) - index + 1
        # print(answer, end=' ')
        # print(arr)

print(answer)


