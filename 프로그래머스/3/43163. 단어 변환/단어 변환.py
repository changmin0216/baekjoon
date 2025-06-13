import sys
answer = 0
def dfs(word, cnt, visited, target, words):
    global answer
    
    if word == target:
        if answer==0:
            answer = cnt
        else:
            if cnt < answer:
                answer = cnt
        return
    
    for i in range(len(words)):
        if not visited[i]:
            cntt = 0
            for j in range(len(words[i])):
                if words[i][j] != word[j]:
                    cntt+=1
            if cntt == 1:
                visited[i] = True
                dfs(words[i], cnt+1, visited, target, words)
                visited[i] = False
                
    return  
def solution(begin, target, words):
    if len(words[0])!=len(begin) or len(begin)!=len(target):
        return 0
    
    visited = [False] * len(words)
    for i in range(len(words)):
        cnt = 0
        for j in range(len(words[i])):
            if words[i][j]!=begin[j]:
                cnt+=1
        if cnt == 1 and not visited[i]:
            visited[i] = True
            dfs(words[i], 1, visited, target, words)
            visited[i] = False
            
    return answer
