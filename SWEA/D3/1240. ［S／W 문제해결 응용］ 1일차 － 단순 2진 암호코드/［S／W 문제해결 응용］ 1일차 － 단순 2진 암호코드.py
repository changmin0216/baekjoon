t = int(input())

for case in range(t):
    n, m = map(int, input().split())

    arr = []
    for _ in range(n):
        arr.append(list(map(int, input())))

    y = -1
    x = -1
    for i in range(n):
        for j in range(m-1, -1, -1):
            if arr[i][j] == 1:
                y = i
                x = j
                break

    x-=55
    l = [[0,0,0,1,1,0,1], [0,0,1,1,0,0,1], [0,0,1,0,0,1,1], [0,1,1,1,1,0,1], [0,1,0,0,0,1,1], [0,1,1,0,0,0,1], [0,1,0,1,1,1,1], [0,1,1,1,0,1,1],[0,1,1,0,1,1,1],[0,0,0,1,0,1,1]]
    answer = []
    for i in range(x, x+56, 7):
        for j in range(len(l)):
            if arr[y][i:i+7] == l[j]:
                answer.append(j)
                break

    odd = 0
    even = 0
    for i in range(len(answer)):
        if (i+1)%2 == 1:
            odd+=answer[i]
        else:
            even+=answer[i]
    if (odd*3 + even)%10 == 0:
        print(f'#{case+1} {sum(answer)}')
    else:
        print(f'#{case+1} 0')