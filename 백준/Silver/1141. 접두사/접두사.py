import sys
input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(input().rstrip())

arr.sort(key=lambda x:len(x))

answer = 0
for i in range(n):
    flag = False
    for j in range(i+1, n):
        if arr[i] == arr[j][0:len(arr[i])]:
            break
    else:
        answer+=1

print(answer)