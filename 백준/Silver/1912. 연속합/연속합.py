n = int(input())
ary = list(map(int, input().split()))
for i in range(1, n):
    ary[i] = max(ary[i], ary[i] + ary[i-1])
answer = max(ary)
print(answer)