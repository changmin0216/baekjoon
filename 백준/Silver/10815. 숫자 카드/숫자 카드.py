def binary_search(array, target, left, right):
    while left <= right:
        mid = (left + right) // 2

        if array[mid] == target:
            return True
        elif array[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return False

import sys
input = sys.stdin.readline

n = int(input())
card = list(map(int, input().split()))

m = int(input())
find = list(map(int, input().split()))

card.sort()
for v in find:
    if binary_search(card, v, 0, n-1):
        print(1, end=' ')
    else:
        print(0, end=' ')
