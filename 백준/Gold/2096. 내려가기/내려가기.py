import sys
input = sys.stdin.readline

n = int(input())

ary = list(map(int, input().split()))

max_dp = ary
min_dp = ary


for i in range(n-1):
    ary = list(map(int, input().split()))

    # max_dp[0] = max(max_dp[0], max_dp[1]) + ary[0]
    # min_dp[0] = min(min_dp[0], min_dp[1]) + ary[0]
    #
    # max_dp[1] = max(max_dp) + ary[1]
    # min_dp[1] = min(min_dp) + ary[1]
    #
    # max_dp[2] = max(max_dp[1], max_dp[2]) + ary[2]
    # min_dp[2] = min(min_dp[1], min_dp[2]) + ary[2]

    max_dp = [max(max_dp[0], max_dp[1]) + ary[0], max(max_dp) + ary[1], max(max_dp[1], max_dp[2]) + ary[2]]
    min_dp = [min(min_dp[0], min_dp[1]) + ary[0], min(min_dp) + ary[1], min(min_dp[1], min_dp[2]) + ary[2]]

print(max(max_dp), min(min_dp))
