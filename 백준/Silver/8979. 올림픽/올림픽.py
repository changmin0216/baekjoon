import sys
input = sys.stdin.readline

n, k = map(int, input().split())

medal = []

for i in range(4):
    a, b, c, d = map(int, input().split())
    if a==k:
        g, s, bronze = b, c, d
    medal.append([a, b, c, d])

# medal.sort(key=lambda x:x[1], reverse=True)

cnt = 0
for i in medal:
    if i[1]>g:
        medal.remove(i)
        cnt+=1

for i in medal:
    if i[2]>s:
        medal.remove(i)
        cnt+=1

for i in medal:
    if i[3]>bronze:
        medal.remove(i)
        cnt+=1

print(cnt)