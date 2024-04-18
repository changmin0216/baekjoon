import sys
input = sys.stdin.readline

n, k = map(int, input().split())

medal = []

for i in range(n):
    a, b, c, d = map(int, input().split())
    if a==k:
        g, s, bronze = b, c, d
        continue
    medal.append([a, b, c, d])

cnt = 0
for i in medal:
    if i[1]>g:
        medal.remove(i)
        cnt+=1

for i in medal:
    if i[2]>s and i[1]==g:
        medal.remove(i)
        cnt+=1

for i in medal:
    if i[3]>bronze and i[1]==g and i[2]==s:
        medal.remove(i)
        cnt+=1

print(cnt+1)


