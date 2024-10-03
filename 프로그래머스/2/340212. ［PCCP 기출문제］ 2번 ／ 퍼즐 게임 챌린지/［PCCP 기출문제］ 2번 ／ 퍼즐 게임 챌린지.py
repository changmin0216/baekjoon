def solution(diffs, times, limit): #현재 퍼즐 난이도, 퍼즐의 소요 시간 ,제한 시간
    answer = 0

    left = 1
    right = 10**15
    while left <= right:
        mid = (left + right) // 2
        sum = 0
        for i in range(len(diffs)):
            if diffs[i] <= mid:
                sum+= times[i]
            else:
                sum+= (diffs[i] - mid) * (times[i] + times[i-1]) + times[i]
            if sum > limit:
                left = mid + 1
                break
        else: #통과했으면
            right = mid - 1

    answer = left
    return answer # 숙련도 최솟값