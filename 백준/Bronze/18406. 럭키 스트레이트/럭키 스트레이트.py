import sys
input = sys.stdin.readline

l = list(map(str, input().rstrip()))
length  = len(l)

left = 0
for i in range(length//2):
    left+=int(l[i])

right = 0
for i in range(length//2, length):
    right+=int(l[i])

if left == right:
    print("LUCKY")
else:
    print("READY")