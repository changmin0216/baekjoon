import sys
input = sys.stdin.readline

l = int(input())
arr = list(map(int, input().split()))
n = int(input())

set_ = set()
for x in arr:
    set_.add(x)

max_num = max(set_) # max_num = 14

cnt = 0
for i in range(1, n+1): #i는 1부터 n까지
    for j in range(n, max_num+1): # j는 n+1부터 max_num 까지
        if i==j: continue

        # i<=k<=j
        for k in range(i, j+1):
            if k in set_:
                break
        else:
            # print(i, j)
            cnt+=1
print(cnt)