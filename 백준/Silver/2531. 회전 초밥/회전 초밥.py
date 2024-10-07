import sys
from collections import Counter
from collections import defaultdict
input = sys.stdin.readline

n, d, k, c = map(int, input().split()) #접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
arr = []
for _ in range(n):
    arr.append(int(input()))

if k == n:
    c = Counter(arr)
    print(len(c))
    exit(0)
elif k==n-1:
    max_ = -1
    for i in range(n):
        d = defaultdict(int)
        for j in range(k):
            index = (i+j)%n
            d[arr[index]]+=1
        d[c]+=1
        max_ = max(max_, len(d))
else:
    max_ = -1
    for i in range(n):
        d = defaultdict(int)
        for j in range(k):
            index = (i+j)%n
            d[arr[index]]+=1
        # if i-1==-1:
        #     check_left_index = n-1
        # else:
        #     check_left_index = i-1
        # check_right_index = (i+k)%n
        #
        # if arr[check_left_index] == c:
        #     d[arr[check_left_index]] += 1
        # if arr[check_right_index] == c:
        #     d[arr[check_right_index]] += 1
        d[c]+=1
        max_ = max(max_, len(d))
print(max_)

