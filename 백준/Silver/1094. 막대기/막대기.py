import sys
input = sys.stdin.readline

x = int(input()) # 23

cur = [64]

while True:
    if sum(cur) == x:
        break
    if sum(cur) > x:
        tmp = cur.pop()
        if tmp//2 + sum(cur) > x:
            cur.append(tmp//2)
        else:
            cur.append(tmp//2)
            cur.append(tmp//2)
    # print(cur)

answer = 0
for x in cur:
    if x!=0:
        answer+=1
print(answer)