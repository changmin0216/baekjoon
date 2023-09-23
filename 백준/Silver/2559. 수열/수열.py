import sys
input = sys.stdin.readline

N, K=map(int, input().split())

nums=list(map(int, input().split()))
each=0
result = []
for i in range(K):
    each+=nums[i]
result.append(each)

for i in range(K, N):
    each += nums[i]
    each -= nums[i-K]
    result.append(each)
print(max(result))