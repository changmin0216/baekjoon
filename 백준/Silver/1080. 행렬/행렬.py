import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr1 = []
for _ in range(n):
    arr1.append(list(map(int, input().rstrip())))

arr2 = []
for _ in range(n):
    arr2.append(list(map(int, input().rstrip())))

def flip(y, x):
    for i in range(y, y+3):
        for j in range(x, x+3):
            if arr1[i][j]==1:
                arr1[i][j] = 0
            else:
                arr1[i][j] = 1

def sol():
    if arr1 == arr2: # 처음에 같은 경우는 바로 0 return
        return 0

    cnt = 0
    for i in range(n-2):
        for j in range(m-2):
            if arr1[i][j] != arr2[i][j]: #만약 서로 다르면 a의 3x3을 전환시킴
                flip(i,j)
                cnt += 1

            if arr1 == arr2:
                return cnt
    return -1

if arr1==arr2:
    print(0)
    exit(0)
else:
    answer = 0
    for i in range(n-2):
        for j in range(m-2):
            if arr1[i][j]!=arr2[i][j]:
                flip(i, j)
                answer += 1

            if arr1 == arr2:
                print(answer)
                exit(0)
    print(-1)