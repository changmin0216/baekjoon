t = int(input())

for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()


    result = 0
    for i in range(n-1):
        for j in range(i+1, n):

            dist = abs(arr[i]-arr[j])

            left = 0
            right = n - 1
            while left<=right:
                mid = (left+right) // 2

                if arr[mid] == arr[j] + dist:
                    result+=1
                    break

                if arr[mid] < arr[j] + dist:
                    left = mid + 1
                else:
                    right = mid -1
    print(result)