import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
array.sort()

result = 0
for i in range(n):
    target = array[i]
    start = 0
    end = n-1
    while start < end:
        if array[start] + array[end] == target:
            if start==i: # 만약 자기 자신이면
                start+=1
            elif end==i: # 만약 자기 자신이면
                end-=1
            else:
                result+=1
                break

        elif array[start] + array[end] > target:
            end-=1
        else:
            start+=1
print(result)