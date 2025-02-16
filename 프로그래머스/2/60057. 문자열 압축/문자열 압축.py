def solution(s):
    result = []
    for i in range(1, len(s)//+1): #1부터 len까지 자를 수 있으니
        cnt=1
        temp = ""
        for j in range(0, len(s), i):
            if s[j:j+i] == s[j+i:j+i+i]:
                cnt+=1
            else:
                if cnt!=1:  ## 이전에 반복 되는게 있으면
                    temp += str(cnt) + s[j:j+i]
                    cnt = 1
                else: ## 이전에 반복 되는게 없으면
                    if i==1:
                        temp += s[j:j+i]
                    else:
                        temp += s[j:j+i]
        result.append(len(temp))
    if result:
        answer = min(result)
    else:
        answer = len(s)
    return answer
