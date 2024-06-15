import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
result = []
ans = 0
def cal(add, sub, mul, div, ans, i):
    if i == n:
        result.append(ans)
        return
    if add>0:
        cal(add-1, sub, mul, div, ans+nums[i], i+1)
    if sub>0:
        cal(add, sub-1, mul, div, ans-nums[i], i+1)
    if mul>0:
        cal(add, sub, mul-1, div, ans*nums[i], i+1)
    if div>0:
        cal(add, sub, mul, div-1, int(ans/nums[i]), i+1)
cal(add, sub, mul, div,  nums[0], 1)
print(max(result))
print(min(result))