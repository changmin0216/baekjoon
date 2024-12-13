import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

# 10, 30, 10, 20, 20, 10
# 1, 1, 2, 2, 2, 3

# 10, 20, 20, 10, 30 , 10
# 1, 2, 2, 2,


# 20, 10, 10, 20, 30
# 1, 1, 1,

# 30, 20, 10, 30, 40
# 1, 1, 1, 2, 3
dp = [1] * n
for i in range(n):
    for j in range(i):
        if arr[i] < arr[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))
# arr_inverse = []
# for x in reversed(arr):
#     arr_inverse.append(x)
# # arr_inverse = reversed(arr)
#
# dp_asc = [0] * n
# dp_asc[0] = 1
#
# for i in range(n-1):
#     if arr_inverse[i] < arr_inverse[i+1]:
#         dp_asc[i+1] = dp_asc[i]+1
#     else:
#         dp_asc[i+1] = dp_asc[i]
#
# print(max(dp_asc))
# dp = [0] * (n+1)
# dp[0] = 1
# max_index = 0
# for i in range(1, n):
#     if arr[i] > arr[i-1]: #10, 30
#         dp[i] = dp[i-1]+1
#     else: ##아닌경우?
#         max_index = i
#         dp[i] =