def solution(myString, pat):
    answer = 0

    str_ = ''
    for c in myString:
        if c == 'A':
            str_ += 'B'
        else:
            str_ += 'A'

    if pat in str_:
        answer = 1

    return answer

