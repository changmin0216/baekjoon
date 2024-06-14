def check(s):
    stack = []
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    return True
def divide(s):
    left, right = 0, 0
    for i in range(len(s)):
        if s[i] == '(':
            left+=1
        else:
            right+=1

        if left==right:
            return s[:i+1], s[i+1:]
def solution(p):
    answer = ''
    if not p:
        return ''

    u, v = divide(p)

    if check(u):
        return u + solution(v)

    else:
        answer+='('
        answer+=solution(v)
        answer+=')'

        for i in u[1:len(u)-1]:
            if i==')':
                answer+='('
            else:
                answer+=')'
    return answer