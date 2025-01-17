def solution(myString):
    answer = []
    for l in myString.split('x'):
        if l != '':
            answer.append(l)
    answer.sort()
    return answer