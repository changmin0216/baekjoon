import sys
input = sys.stdin.readline

n = int(input())

budget_list = list(map(int, input().split()))

budget = int(input())

# if budget >= sum(budget_list):
#     print(max(budget_list))
#     exit(0)

budget_list.sort()

left = 1
right = budget_list[-1]

while left <= right:
    mid = (left + right) // 2

    sum = 0
    for v in budget_list:
        if v <= mid:
            sum+=v
        else:
            sum+=mid

    if sum <= budget:
        left = mid + 1
    else:
        right = mid -1

print(left-1)