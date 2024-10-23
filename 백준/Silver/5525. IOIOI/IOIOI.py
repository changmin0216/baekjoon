import sys
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
for i in range(m):
    if s[i] == 'I':
        if s[i:i+len(p)] == p:
            cnt+=1
print(cnt)