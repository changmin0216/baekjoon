import sys
input = sys.stdin.readline

n = int(input())

arr = []
for i in range(n):
    arr.append(list(map(str, input().rstrip())))

answer = -1
for i in range(n):
    cnt = 0
    for j in range(n):
        if i==j:
            continue
        if arr[i][j] == 'Y':
            cnt+=1
        else: # 친구가 아니면 0과 1이 친구가 아니면
            # arr[0][i] == arr[1][i] 두 개 다 Y인 얘들을 찾으면 되는거 아님?
            # i==j인 경우는 포함X
            for k in range(n):
                if arr[j][k] == 'Y' and arr[i][k] == 'Y':
                    cnt+=1
                    break
    answer = max(answer, cnt)

print(answer)