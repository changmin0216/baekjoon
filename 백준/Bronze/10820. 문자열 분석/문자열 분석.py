import sys
input = sys.stdin.readline
sol=[]
for _ in range(100):
    s = list(input().rstrip('\n'))
    if not s:
        break
    temp = [0]*4
    for i in range(len(s)):
        if s[i].isdigit():
            temp[2]+=1
        elif s[i] == ' ':
            temp[3]+=1
        elif ord('a') <= ord(s[i]) <= ord('z'): ##소문자
            temp[0]+=1
        else:
            temp[1]+=1
    print(*temp)

