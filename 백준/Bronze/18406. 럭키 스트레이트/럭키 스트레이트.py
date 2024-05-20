import sys
input = sys.stdin.readline

n = int(input())
l = len(str(n))

left, right = 0, 0
for i in range(l):
    if i < l//2:
        left+=int(str(n)[i])
    else:
        right += int(str(n)[i])

if left==right:
    print("LUCKY")
else:
    print("READY")