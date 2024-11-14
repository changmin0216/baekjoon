import sys
input = sys.stdin.readline

n = int(input())
arr_A = list(map(int, input().split()))

sorted_list = sorted(arr_A)

answer = []
for i in range(len(arr_A)):
    for j in range(len(arr_A)):
        if arr_A[i] == sorted_list[j]:
            if j not in answer:
                answer.append(j)
                break

print(' '.join(map(str, answer)))