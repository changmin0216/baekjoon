import sys
from collections import Counter
input = sys.stdin.readline

word = list(input().rstrip())
check = Counter(word)

cnt = 0
mid = ''
for k, v in list(check.items()):
    if v%2==1:
        mid = k
        cnt+=1

if cnt>1:
    print("I'm Sorry Hansoo")
    exit(0)

result = ''
for k, v in sorted(check.items()): #정렬을 통해 사전순으로 for문을 돌게함
    result += (k * (v // 2)) #정확히 절반으로 나뉜 문자열을 만들어야 하므로 현재 갯수를 2로 나눠줌
print(result + mid + result[::-1]) # 앞+중간+뒤 를 더해 문자열 출력