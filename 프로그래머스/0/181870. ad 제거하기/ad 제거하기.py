def solution(strArr):
    answer = []
    for l in strArr:
        if 'ad' not in l:
            answer.append(l)
    return answer