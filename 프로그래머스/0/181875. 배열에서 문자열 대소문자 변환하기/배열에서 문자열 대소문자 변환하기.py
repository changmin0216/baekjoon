
def solution(strArr):
    list_ = []
    for i in range(len(strArr)):
        if i%2==0:
            list_.append(strArr[i].lower())
        else:
            list_.append(strArr[i].upper())
    return list_

# print(solution(["AAA","BBB","CCC","DDD"]))