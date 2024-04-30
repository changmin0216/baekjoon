def binary_search(arr, target, index):
    left = 0
    right = len(arr)-1

    while left < right:
        temp = arr[left] + arr[right]

        if temp==target:
            if left == index:
                left+=1
                continue
            elif right == index:
                right-=1
                continue
            else:
                return True
        elif temp > target:
            right-=1
        else:
            left+=1

    return False
import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
array.sort()

result = 0
for i in range(n):
    if binary_search(array, array[i], i):
        result+=1

print(result)