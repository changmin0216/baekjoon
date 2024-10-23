import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().rstrip()

p = ''
for i in range(n+1):
    if i==n:
        p+='I'
    else:
        p+='IO'

cnt = 0

start = 0
end = 0

q = deque()
q.append(s[0])
while end<m and start<=end:
    if s[end]!='I':
        end+=1
        if end<m:
            q.append(s[end])
    else: # s[end]=='I'
        if s[start]!='I':
            start+=1
            q.popleft()
        else: # s[end] == 'I' and s[start] == 'I'
            if len(q)==len(p):
                if ''.join(q) == p:
                    cnt+=1
                end+=1
                if end < m:
                    q.append(s[end])
            else: #둘다 i긴 한데 길이가 다른 경우
                if len(q) < len(p):
                    end+=1
                    if end < m:
                        q.append(s[end])
                else:
                    start+=1
                    q.popleft()
print(cnt)