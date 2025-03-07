import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
cal = list(map(int, input().split()))

result = []
def recur(depth, sum_, idx):
    if idx==0:
        sum_+=arr[depth]
    elif idx==1:
        sum_ -= arr[depth]
    elif idx==2:
        sum_ *= arr[depth]
    else:
        if sum_ < 0 and arr[depth] > 0:
            sum_ = -((-sum_) // arr[depth])
        else:
            sum_ //= arr[depth]

    if depth == n-1:
        result.append(sum_)
        return

    for i in range(len(cal)):
        if cal[i] != 0:
            cal[i] -= 1
            recur(depth+1, sum_, i)
            cal[i] += 1


for i in range(len(cal)):
    if cal[i] != 0:
        cal[i]-=1
        recur(1, arr[0], i)
        cal[i]+=1

print(max(result))
print(min(result))