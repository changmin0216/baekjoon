def solution(my_string, n):
    answer = ''
    for c in my_string:
        for i in range(n):
            answer+=c
    return answer