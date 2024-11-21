import sys
input = sys.stdin.readline

l, r = map(str, input().split())

if len(l)!=len(r): #두 자리수가 다르면 8이 안나오는 경우가 무조건 나온다고?
    print(0)
else: #두 자리수가 같을 때
    answer = 0
    for i in range(len(l)): 
        if l[i]==r[i]:
            if l[i] == '8':
                answer+=1
        else:
            break
    print(answer)